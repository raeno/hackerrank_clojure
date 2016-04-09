(ns algorithms.implementation.service-lane
  (:require [clojure.string :refer [split]]))

(defn- numbers-from-string
  [string]
  (map read-string (split string #"\s+")))

(defn largest-vehicle
  [freeway segment-start segment-end]
  (let [distance (inc (- segment-end segment-start))
        segment-widths (take distance (drop segment-start freeway))
        min-width (apply min segment-widths)]
  min-width))

(defn solution
  []
  (let [[freeway-length testcases-count] (numbers-from-string (read-line))
        width (numbers-from-string (read-line))]
    (dotimes [n freeway-length]
      (let [[start end] (numbers-from-string (read-line))]
        (println (largest-vehicle width start end))))))

