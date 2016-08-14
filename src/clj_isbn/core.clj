(ns clj-isbn.core 
  (require [clojure.data.json :as json]
           [clojure.string :as str]))

(def ^:private data 
  "A (pretty huge) hashmap containing data about registration groups.
  Used for code hyphenation."
  (json/read-str (slurp "ranges.json")))

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
   In: string, out: integer" 
  [isbn]
  (let [nsum
    (->> isbn
         (normalize)
         (take 9)
         (map-indexed (fn [idx itm] (* (- 10 idx) (charToInt itm))))
         (reduce +))]
    (mod (- 11 (mod nsum 11)) 11)))

(defn isbn13-checkdigit
  "Takes an ISBN 13 code as string, returns the check digit
   In: string, out: integer" 
  [isbn]
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
      (if (= 10 digit) 0 digit))))

(defn check-digit-correct?
  "Takes and ISBN and checks its validity by the check digit
   In: string, out: boolean"
  [isbn]
  (let [isbn (normalize isbn)]
    (let [digit 
          (if (= (count isbn) 10) 
            (isbn10-checkdigit isbn)
            (isbn13-checkdigit isbn))]
      (= digit (charToInt (last isbn))))))

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
  (let [firstchars (apply str "978" (take 9 (normalize isbn10)))]
    (str firstchars (isbn13-checkdigit firstchars))))

(defn isbn13->isbn10
  "Takes an ISBN 13 code and returns a corresponding ISBN 10
  In: string, out: string"
  [isbn13]
  (let [firstchars (apply str (take 9 (drop 3 (normalize isbn13))))]
    (str firstchars (isbn10-checkdigit firstchars))))

(defn publisher-zone
  "Takes an ISBN and returns the publisher's country.
  In: string, out: string."
  [isbn]
  (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
    (last (find (get-data isbn) "name"))))

(defn hyphenate
  "Takes an ISBN, returns it with hyphens added
  In: string, out: string"
  [isbn]
  (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
    (let [prefix (get-prefix isbn) 
          ranges (last (get-ranges isbn))
          isbn-body (apply str (drop-last (drop (dec (count prefix)) isbn)))
          check-digit (last isbn)]
      ; Determine the registrant element
      (let [reglength 
            (count (str
              (loop [i 0]
                (let [beg (stringToInt (first (get ranges i)))
                      end (stringToInt (last (get ranges i)))
                      len (count (first (get ranges i)))
                      area (stringToInt (subs isbn-body 0 (inc len)))]
                  (if (<= beg area end) area (recur (inc i)))))))]
        (let [registrant-element (subs isbn-body 0 reglength)]
          registrant-element)))))

(defn get-registrant-element
  "Takes an ISBN, returns the lenght of the registrant element
  In: string, out: string"
  [isbn]
  (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
    (let [prefix (get-prefix isbn) 
          ranges (last (get-ranges isbn))
          isbn-body (apply str (drop-last (drop (dec (count prefix)) isbn)))]
          ; Determine the registrant element
          (loop [i 0]
            (let [beg (stringToInt (first (get ranges i)))
                  end (stringToInt (last (get ranges i)))
                  len (count (last (get ranges i)))
                  area (stringToInt (subs isbn-body 0 len))
                  values (str beg " " end " " len " " area)]
              ;(println values "\n" ranges)
              (if (<= beg area end) (subs isbn-body 0 len) (recur (inc i))))))))

(defn get-publication-element
  ""
  [isbn]
  (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
    (let [prefix (normalize (get-prefix isbn))
          isbn-body (apply str (drop-last (drop (count prefix) isbn)))
          reg-element (get-registrant-element isbn)]
      (string-drop (count reg-element) isbn-body))))

(defn get-checkdigit
  ""
  [isbn]
  (str (last isbn)))

(defn hyphenate-isbn13
  ""
  [isbn]
  (str 
    (get-prefix isbn) "-" 
    (get-registrant-element isbn) "-" 
    (get-publication-element isbn) "-"
    (get-checkdigit isbn)))

(defn hyphenate-isbn10
  ""
  [isbn]
  (let [fullprefix (get-prefix (isbn10->isbn13 isbn))]
    (let [isbn10-prefix (last (str/split fullprefix #"-"))]
      (str isbn10-prefix "-" 
           (get-registrant-element isbn) "-"
           (get-publication-element isbn) "-"
           (get-checkdigit isbn)))))

(defn hyphenate
  ""
  [isbn]
  (if (isbn10? isbn) (hyphenate-isbn10 isbn) (hyphenate-isbn13 isbn)))
