(ns functional.recursion.string-o-permute-test
  (:require [clojure.test :refer :all]
            [functional.recursion.string-o-permute :refer :all]))

(deftest swap-chars-test
  (is (= '(\b \a \d \c \q \p \s \r) (swap-chars [\a \b \c \d \p \q \r \s])))
  (is (= '("x" "y") (swap-chars ["y" "x"])))
)

(deftest swap-string-test
  (is (= "yx" (swap-string "xy")), "Swaps symbols in short strings")
  (is (= "badcfehg", (swap-string "abcdefgh")), "Swaps symbols in long strings"))
