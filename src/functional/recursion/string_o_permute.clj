(ns functional.recursion.string-o-permute
  (:require [clojure.string :refer [split join]]))

(defn- swap-chars-recur
  ([symbols] (swap-chars-recur symbols '()))
  ([symbols result]
    (let [[x y & more] symbols
          new-result (conj result y x)]
      (if (not more)
        new-result
        (recur more new-result)))))

(defn swap-chars [characters] (reverse (flatten (swap-chars-recur characters))))
(defn swap-string [string] (join (swap-chars (seq string))))

(defn solution
  []
  (let [test-cases (read-string (read-line))]
    (dotimes [_ test-cases]
      (let [input-string (read-line)] (println (swap-string input-string))))))
