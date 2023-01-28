(ns playground.logic
  (:gen-class)
  (:require [clojure.core.logic :as l]
            [clojure.core.logic.pldb :as pldb]))

(pldb/db-rel conjunction a b)
(pldb/db-rel disjunction a b)

(AB|C) = (B|C) (A|BC)

(def facts0
  (pldb/db
   [prime 3]
   [prime 5]
   [prime 7]
   [prime 11]
   [prime 13]
   [prime 17]
   [prime 19]
   [prime 23]
   [prime 29]
   [prime 31]
   [prime 37]))

(pldb/with-db facts-nums
 (l/run* [q]
   (l/fresh [x y]
     (prime q)
     (l/== q (+ (* x x) (* y y))))))

(pldb/with-db facts-nums
 (l/run* [q]
   (l/fresh [x y]
     (prime q)
     (l/== q (+ (* x x) (* y y))))))
