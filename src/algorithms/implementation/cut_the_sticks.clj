; You are given NN sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

; Suppose we have six sticks of the following lengths:
; 5 4 4 2 2 8

; Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following: 
; 3 2 2 6

; The above step is repeated until no sticks are left.

; Given the length of NN sticks, print the number of sticks that are left before each subsequent cut operations.

; Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).

(ns algorithms.implementation.cut-the-sticks
  (:require [clojure.string :refer [split triml]]))

(defn cut-array
  [array]
  (let [array-size (count array)]
    (cond 
      (= array-size 0) []
      (> array-size 0) (
        (let [min-stick (apply min array)
              trimmed-array (map (fn [x] (- min-stick x)) array) 
              new-array (filter pos? trimmed-array)]
          (println array-size)
          (cut-array new-array))))))

(defn solution
  []
  (let [n (Integer/parseInt (read-line)) 
        arr_temp (read-line) 
        arr_t (split arr_temp #"\s+") 
        arr (map #(Integer/parseInt %) arr_t)]
      (cut-array arr)))

