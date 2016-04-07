(ns algorithms.implementation.manasa-and-stones-test
  (:require [clojure.test :refer :all]
            [algorithms.implementation.manasa-and-stones :refer :all]))

(deftest last-possible-stones-test
  (is (= '(2 3 4) (last-possible-stones 3 1 2)))
  (is (= '(30 120 210 300) (last-possible-stones 4 10 100)))) 
