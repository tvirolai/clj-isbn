(ns clj-isbn.core
  (:gen-class))

(defn normalize [isbn]
  (apply str (filter #(or (Character/isDigit %) (= \X %)) isbn)))

(defn charToInt [c]
  (if (= c \X) 10
  (Character/digit c 10)))

(defn validate [isbn]
  (let [isbn (normalize isbn)]
    (let [checkDigit (charToInt (nth isbn (- (count isbn) 1)))]
      (loop [i 0 sum 0 pos (count isbn)]
        (let [no (charToInt (int (nth isbn i)))]
          (if (= pos 1)
            ;(= (mod no 11) checkDigit)
            (= (mod (+ sum (* checkDigit pos)) 11) 0)
            (do
              (println (str "index: " i " number: " (nth isbn i) " sum: " sum " current no: " no " " isbn " checkDigit: " checkDigit " pos: " pos))
              (recur (inc i) (+ sum (* no pos)) (dec pos)))))))))


(defn -main
  "A to-be ISBN code utility library for Clojure. A work in progress."
  [& args]
  (println (validate "951-98548-9-1")))
