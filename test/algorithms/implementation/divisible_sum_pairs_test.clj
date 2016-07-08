(ns algorithms.implementation.divisible-sum-pairs-test
  (:require [clojure.test :refer :all]
            [algorithms.implementation.divisible-sum-pairs :refer :all]))

(deftest count-pairs-test
  (let [numbers [1 3 2 6 1 2]
        divider 3]
    (is (= 5 (count-pairs numbers divider)))
  )
)
