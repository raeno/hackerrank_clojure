(ns statistics.day-1.basic-statistics-test
  (:require [clojure.test :refer :all]
            [clojure.math.numeric-tower :refer [sqrt]]
            [statistics.day-1.basic-statistics :refer :all]))

(deftest mean-test
  (testing "Mean is average of all passed numbers"
    (is (= 3.0 (mean 1 2 3 4 5)))))

(deftest array-median-test
  (is (= 3 (array-median 3 4 5 2 1)) "Array median is middle element of odd size array")
  (is (= 6.5 (array-median 5 8 7 6)) "Array median is average of two middle elements ofor even size array"))

(deftest mode-test
  (is (= 4 (mode 2 4 1 2 3 4 4 5 4 1)), "Mode returns most ocurrent element")
  (is (= 2 (mode 1 2 2 3 3)), "Mode returns smalles most occurent if there are many")
  (is (= nil (mode)), "Returns nil if no arguments"))

(deftest standart-deviation-test
  (is (= 2.0 (standard-deviation 1 2 3 4 5 6 7))))
