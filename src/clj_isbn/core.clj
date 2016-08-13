(ns clj-isbn.core
  (require [clojure.xml :as xml]
           [clojure.zip :as zip]))

(defn- normalize [isbn]
  (apply str (filter #(or (Character/isDigit %) (= \X %)) isbn)))

(defn- charToInt [c]
  (if (= c \X) 10
    (Character/digit c 10)))

(defn- length-correct?
  "Takes an ISBN and checks that its length is correct.
   In: string, out: boolean"
  [isbn]
  (contains? #{10 13 17} (count isbn)))

(defn- no-erroneous-chars?
  "Takes an ISBN and checks if it contains characters that
  don't belong to an ISBN.
  In: string, out: boolean"
  [isbn]
  (length-correct? (normalize isbn)))

(defn- zip-str [s]
  (zip/xml-zip 
      (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))

(def isbn-ranges (zip-str (slurp "./data/RangeMessage.xml")))

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
  (- 10 (mod nsum 10))))

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

(defn hyphenate
  "Takes an ISBN, returns it with hyphens added
  In: string, out: string"
  [isbn]
  isbn)

