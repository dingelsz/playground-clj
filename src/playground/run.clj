(ns playground.run
  (:gen-class)
  (:require [clojure.core.match :refer [match]]))

(defn run [ast]
  "Evaluates an AST"
  (cond (string? ast) (read-string ast)
        (= 3 (count ast)) (let [[op x y] ast
                                x (run x)
                                y (run y)]
                            (match [op]
                                   [:sum] (+ x y)
                                   [:sub] (- x y)
                                   [:mul] (* x y)
                                   [:div] (/ x y)
                                   :else ()))
        :else nil))
