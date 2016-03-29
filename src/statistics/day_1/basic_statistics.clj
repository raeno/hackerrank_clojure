(ns statistics.day-1.basic-statistics
  (:require [clojure.math.numeric-tower :refer :all]
            [clojure.string :refer [split]]))

(defn mean
  ([] nil)
  ([& arguments]
  (/ (reduce + arguments) (double (count arguments)))))

(defn array-median
  [& arguments]
  (let [size (count arguments)
        sorted-arguments (sort arguments)
        item #(nth sorted-arguments %1)]

    (if (even? size)
      (double (/
                (+ (item (/ (inc size) 2))
                   (item (/ (dec size) 2)))
                2))
      (item (/ size 2)))))

(defn mode
  ([] nil)
  ([& arguments]
  (let
    [ frequencies-arr (frequencies arguments)
      highest-frequency (apply max (map val frequencies-arr))
      most-ocurrent (filter #(= highest-frequency (last %1)) frequencies-arr)
    ]
    (apply min (map first most-ocurrent)))))

(defn standard-deviation
  [& arguments]
  (let [args-mean (apply mean arguments)
        pow2 #(expt %1 2)
        deviations (map #(pow2 (- %1 args-mean)) arguments)
        size (count arguments)
       ]
    (sqrt (/ (reduce + deviations) size))))

(defn solution
  []
  (let [_ (read-line)
        arr-temp (split (read-line) #"\s+")
        arr (map #(Integer/parseInt %) arr-temp)]
    (def results (apply (juxt mean array-median mode standard-deviation) arr))
    (dorun (map println results))))


