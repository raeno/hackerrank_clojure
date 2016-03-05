(use '[clojure.string :only (split triml)])

(
        let [
          n_temp (read-line) 
          n_t (split n_temp #"\s+") 
          n (Integer/parseInt (n_t 0)) 
          t (Integer/parseInt (n_t 1)) 
        ]

      (
        let [
          width_temp (read-line) 
          width_t (split width_temp #"\s+") 
          width (map #(Integer/parseInt %) width_t) 
        ]
        (def width-array width)
      )

      (
        loop [a0 t]
        (when (> a0 0)

          (
            let [
              start-end-strings (split (read-line) #"\s+") 
              start (Integer/parseInt (start-end-strings 0)) 
              end (Integer/parseInt (start-end-strings 1))
              distance (+ 1 (- end start))
              subarray (take distance (drop start width-array))
              min-width (apply min subarray)
            ]
            (println min-width)
          )
        (recur (- a0 1) ) )
      )
)

