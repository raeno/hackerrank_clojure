(ns functional.recursion.string-compression)

(defn- value-or-empty [value] (if (= value 1) "" value))

(defn- count-till-next-different
  [symbols char-to-count]
  (loop [list-to-process symbols
         acc 1]
    (if (= char-to-count (first list-to-process))
      (recur (rest list-to-process) (inc acc))
      [list-to-process (str char-to-count (value-or-empty acc))])))

(defn- count-chars
  ([symbols] (count-chars symbols ""))
  ([symbols result]
    (let [current-char (first symbols)
          [new-list counted] (count-till-next-different (rest symbols) current-char)
          new-result (str result counted)]
      (if (empty? new-list)
        new-result
        (recur new-list new-result)))))

(defn string-compression [string] (count-chars (seq string)))

(defn solution
  []
  (println (string-compression (read-line))))
