(ns clj-isbn.core
  (:require [clojure.string :as s]
            [clj-isbn.data :as d]))

(def ^:private data
  "A hashmap containing data about registration groups,
  publisher zones and the like."
  d/data)

(defn- normalize [isbn]
  (->> isbn
       (filter #(or (Character/isDigit %) (= \X %)))
       s/join))

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
  (s/join (take amount string)))

(defn- string-drop
  [amount string]
  (s/join (drop amount string)))

(defn- get-prefix
  ([isbn13]
   (let [isbn (normalize isbn13)]
     (get-prefix (string-take 3 isbn)
                 (string-drop 3 isbn)
                 1)))
  ([prefix body seclenght]
   (let [searchprefix (str prefix "-" (string-take seclenght body))]
     (if (contains? data searchprefix)
       searchprefix
       (recur prefix body (inc seclenght))))))

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
           (map-indexed (fn [idx itm] (* (- 10 idx) (Character/digit itm 10))))
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
               (let [itm (Character/digit itm 10)]
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
    (let [firstchars (s/join (take 9 (drop 3 (normalize isbn13))))]
      (str firstchars (isbn10-checkdigit firstchars)))))

(defn publisher-zone
  "Takes an ISBN and returns the publisher's country.
  In: string, out: string."
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [parsed-isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
      (last (find (get-data parsed-isbn) "name")))))

(defn get-registrant-element
  "Takes an ISBN, returns the registrant element.
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
      (let [prefix (get-prefix isbn)
            ranges (last (get-ranges isbn))
            isbn-body (->> isbn (drop (dec (count prefix))) drop-last s/join)]
            (loop [i 0]
              (let [beg (Integer. (first (get ranges i)))
                    end (Integer. (last (get ranges i)))
                    len (count (last (get ranges i)))
                    area (Integer. (subs isbn-body 0 len))]
                (if (<= beg area end) (subs isbn-body 0 len) (recur (inc i)))))))))

(defn get-publication-element
  "Extracts the publication element from and ISBN.
  In: string, out: string"
  [isbn]
  (when (is-valid? (normalize isbn))
    (let [isbn (if (isbn10? isbn) (isbn10->isbn13 isbn) (normalize isbn))]
      (let [prefix (normalize (get-prefix isbn))
            isbn-body (->> isbn (drop (count prefix)) drop-last s/join)
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
      (let [isbn10-prefix (last (s/split fullprefix #"-"))]
        (str isbn10-prefix "-"
             (get-registrant-element isbn) "-"
             (get-publication-element isbn) "-"
             (get-checkdigit isbn))))))

(defn hyphenate
  "Takes an ISBN code and returns a hyphenated version of it
  In: string, out: string"
  [isbn]
  (if (isbn10? isbn) (hyphenate-isbn10 isbn) (hyphenate-isbn13 isbn)))

(defn correctly-hyphenated?
  "Checks whether an ISBN code is correctly hyphenated. If the
  input is not hyphenated, that counts as no.
  In: string, out: boolean."
  [isbn]
  (= isbn (hyphenate isbn)))
