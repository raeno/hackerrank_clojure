(ns algorithms.implementation.divisible-sum-pairs
  (:require [clojure.string :refer [split]]))

(defn- numbers-from-string
  [string]
  (map read-string (split string #"\s+")))

(defn- all-pairs [coll]
  (when-let [s (next coll)]
    (lazy-cat (for [y s] [(first coll) y])
              (all-pairs s))))

(defn count-pairs
  [numbers divider]
  (let [pairs (all-pairs numbers)
        filtered (filter (fn [[a b]] (= (mod (+ a b) divider) 0)) pairs)]
    (count filtered)))

(defn solution
  []
  (let [[n k] (numbers-from-string (read-line))
        numbers (numbers-from-string (read-line))]
    (println (count-pairs numbers k))))
