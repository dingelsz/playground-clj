(ns playground.calculator
  (:gen-class)
  (:require [playground.parse]
            [playground.run]
            [playground.db]))

(defn calculate [input]
  (playground.run/run (playground.parse/parse input)))

(defn calculate-cached [input]
  (if-let [cache-hit (playground.db/query-calc-result input)]
    cache-hit
    (do
      (playground.db/insert-calc input (calculate input))
      (calculate-cached input))))



