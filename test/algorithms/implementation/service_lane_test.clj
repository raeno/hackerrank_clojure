(ns algorithms.implementation.service-lane-test
  (:require [clojure.test :refer :all]
            [algorithms.implementation.service-lane :refer :all]))


(deftest largest-vehicle-test
  (let [freeway [2 3 1 2 3 2 3 3]]
    (is (= 1 (largest-vehicle freeway 0 3)))
    (is (= 2 (largest-vehicle freeway 4 6)))
    (is (= 3 (largest-vehicle freeway 6 7)))
    (is (= 1 (largest-vehicle freeway 0 7)))))



