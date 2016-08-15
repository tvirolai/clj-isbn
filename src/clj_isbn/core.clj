(ns clj-isbn.core 
  (require [clojure.string :as str]
           [clj-isbn.data :as d]))

(def ^:private data 
  "A (pretty huge) hashmap containing data about registration groups.
  Used for code hyphenation."
  d/data)

(defn- normalize [isbn]
  (apply str (filter #(or (Character/isDigit %) (= \X %)) isbn)))

(defn- charToInt [c]
  (if (= c \X) 10
    (Character/digit c 10)))

(defn- stringToInt [string]
  (Integer. string))

(defn- length-correct?
  "Takes an ISBN and checks that its length is correct.
   In: string, out: boolean"
  [isbn]
  (contains? #{10 13 17} (count isbn)))

(defn- isbn10?
  "Determines if the ISBN received as input is ISBN-10"
  [isbn]
  (= 10 (count (normalize isbn))))

(defn- no-erroneous-chars?
  "Takes an ISBN and checks if it contains characters that
  don't belong to an ISBN.
  In: string, out: boolean"
  [isbn]
  (length-correct? (normalize isbn)))

(defn- string-take
  [amount string]
  (apply str (take amount string)))

(defn- string-drop
  [amount string]
  (apply str (drop amount string)))

(defn- get-prefix
  "Takes an ISBN-13 and returns the correct prefix.
  In: string, out: string"
  [isbn13]
  (let [isbn (normalize isbn13)]
    (let [prefix (string-take 3 isbn) body (string-drop 3 isbn)]
      (loop [seclength 1]
        (let [searchprefix (str prefix "-" (string-take seclength body))]
          (if (contains? data searchprefix)
            searchprefix
            (recur (inc seclength))))))))

(defn- get-data
  "Takes an ISBN and fetches range information
  In: string, out: hashmap"
  [isbn]
  (get data (get-prefix isbn)))

(defn- get-ranges
  ""
  [isbn]
  (find (get-data isbn) "ranges"))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; PUBLIC FUNCTIONS ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn isbn10-checkdigit 
  "Takes an ISBN 10 code as string, returns the check digit
   In: string, out: integer (or string, if the digit is 'X')"
  [isbn]
  (when (<= 8 (count (normalize isbn)) 10)
    (let [nsum
      (->> isbn
           (normalize)
           (take 9)
           (map-indexed (fn [idx itm] (* (- 10 idx) (charToInt itm))))
           (reduce +))]
      (let [digit (mod (- 11 (mod nsum 11)) 11)]
        (if (= 10 digit) "X" digit)))))

(defn isbn13-checkdigit
  "Takes an ISBN 13 code as string, returns the check digit
   In: string, out: integer" 
  [isbn]
  (when (<= 11 (count (normalize isbn)) 13)
    (let [nsum
      (->> isbn
           (normalize)
           (take 12)
           (map-indexed 
             (fn [idx itm] 
               (let [itm (charToInt itm)] 
                 (if (odd? idx) (* itm 3) itm))))
           (reduce +))]
      (let [digit (- 10 (mod nsum 10))]
        (if (= 10 digit) 0 digit)))))

(defn check-digit-correct?
  "Takes an ISBN and checks its validity by the check digit
   In: string, out: boolean"
  [isbn]
  (let [isbn (normalize isbn)]
    (let [digit 
          (str
            (if (= (count isbn) 10) 
              (isbn10-checkdigit isbn)
              (isbn13-checkdigit isbn)))]
      (= digit (str (last isbn))))))

(defn is-valid?
  "Takes and ISBN and checks its validity by 
  checking the check digit, length and characters.
  In: string, out: boolean"
  [isbn]
  (and 
    (check-digit-correct? isbn)
    (length-correct? isbn)
    (no-erroneous-chars? isbn)))

(defn isbn10->isbn13
  "Takes an ISBN 10 code and returns a corresponding ISBN 13
  In: string, out: string"
  [isbn10]
  (when (is-valid? (normalize isbn10))
    (let [firstchars (apply str "978" (take 9 (normalize isbn10)))]
      (str firstchars (isbn13-checkdigit firstchars)))))

(defn isbn13->isbn10
  "Takes an ISBN 13 code and returns a corresponding ISBN 10
  In: string, out: string"
  [isbn13]
  (when (is-valid? (normalize isbn13))
    (let [firstchars (apply str (take 9 (drop 3 (normalize isbn13))))]
      (str firstchars (isbn10-checkdigit firstchars)))))

(defn publisher-zone
  "Takes an ISBN and returns the publisher's country.
  In: string, out: string."
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
      (last (find (get-data isbn) "name")))))

(defn get-registrant-element
  "Takes an ISBN, returns the registrant element.
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
      (let [prefix (get-prefix isbn) 
            ranges (last (get-ranges isbn))
            isbn-body (apply str (drop-last (drop (dec (count prefix)) isbn)))]
            (loop [i 0]
              (let [beg (stringToInt (first (get ranges i)))
                    end (stringToInt (last (get ranges i)))
                    len (count (last (get ranges i)))
                    area (stringToInt (subs isbn-body 0 len))]
                (if (<= beg area end) (subs isbn-body 0 len) (recur (inc i)))))))))

(defn get-publication-element
  "Extracts the publication element from and ISBN.
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
      (let [prefix (normalize (get-prefix isbn))
            isbn-body (apply str (drop-last (drop (count prefix) isbn)))
            reg-element (get-registrant-element isbn)]
        (string-drop (count reg-element) isbn-body)))))

(defn get-checkdigit
  "Extracts the check digit from an ISBN.
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (str (last isbn))))

(defn hyphenate-isbn13
  "Hyphenates an ISBN-13 code
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (str 
      (get-prefix isbn) "-" 
      (get-registrant-element isbn) "-" 
      (get-publication-element isbn) "-"
      (get-checkdigit isbn))))

(defn hyphenate-isbn10
  "Hyphenates an ISBN-10 code
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [fullprefix (get-prefix (isbn10->isbn13 isbn))]
      (let [isbn10-prefix (last (str/split fullprefix #"-"))]
        (str isbn10-prefix "-" 
             (get-registrant-element isbn) "-"
             (get-publication-element isbn) "-"
             (get-checkdigit isbn))))))

(defn hyphenate
  "Takes an ISBN code and returns a hyphenated version of it
  In: string, out: string"
  [isbn]
  (if (isbn10? isbn) (hyphenate-isbn10 isbn) (hyphenate-isbn13 isbn)))
