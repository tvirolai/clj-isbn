(ns clj-isbn.core
  (:gen-class))

(defn normalize [isbn]
  (apply str (filter #(Character/isDigit %) isbn)))

(defn charToInt [c]
  (Character/digit c 10))

(defn validate [isbn]
  (let [checkDigit (charToInt (nth isbn (- (count isbn) 1)))]
    (loop [i 0 sum 0]
      (let [no (charToInt (int (nth isbn i)))]
        (if (= (count isbn) (+ 1 i))
          ;(= (mod no 11) checkDigit)
          (mod (+ sum (* no i)) 11)
          (do
            (println (str "index: " i " number: " (nth isbn i) " sum: " sum " current no: " no " " isbn " checkDigit: " checkDigit))
            (recur (inc i) (+ sum (* no i)))))))))


(defn -main
  "A to-be ISBN code utility library for Clojure. A work in progress."
  [& args]
  (println (validate (normalize "951-98548-9-1"))))
