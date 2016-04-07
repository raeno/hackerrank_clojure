(ns algorithms.implementation.manasa-and-stones
  (:require [clojure.set :refer :all]))

(defn- next-stones [current-stone a b] [(+ current-stone a) (+ current-stone b)])

(defn- new-stones [stones a b] (flatten (map #(next-stones % a b) stones)))

(defn- append-stones [stones new-stones] (union stones (set new-stones)))

(defn last-possible-stones 
  [stones-count a b]
  (let [stones #{0}]
    (loop [stones #{0} stone 1]
      (if (= stone stones-count)
        stones
        (recur (sort (set (new-stones stones a b))) (inc stone))))))

(defn solution
  []
  (let [read-input (fn [] (read-string (read-line)))
        test-cases (read-input)]
    (dotimes [_ test-cases]
      (let [stones-count (read-input)
            a (read-input)
            b (read-input)]
        (apply println (last-possible-stones stones-count a b))))))
