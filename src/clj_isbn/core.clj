(ns clj-isbn.core
  (:gen-class))

(defn normalize [isbn]
  (apply str (filter #(or (Character/isDigit %) (= \X %)) isbn)))

(defn charToInt [c]
  (if (= c \X) 10
    (Character/digit c 10)))

(defn isbn10-checkdigit [isbn]
  (let [isbn (normalize isbn)]
    (loop [i 0 sum 0 pos (count isbn)]
      (let [no (charToInt (int (nth isbn i)))]
        (if (= pos 1)
          (do
            (let [digit (- 11 (mod sum 11))]
              (cond
                (> digit 10) 0
                (= digit 10) "X"
                :else digit)))
          (recur (inc i) (+ sum (* no pos)) (dec pos)))))))

(defn -main
  "A to-be ISBN code utility library for Clojure. A work in progress."
  [& args]
  (println (validate "951-98548-9-1")))
