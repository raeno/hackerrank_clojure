(ns functional.recursion.string-compression-test
  (:require [functional.recursion.string-compression :refer :all]
            [clojure.test :refer :all]))

(deftest string-compression-test
  (is (= "abcd" (string-compression "abcd")))
  (is (= "a2bc3dad2" (string-compression "aabcccdadd"))))
