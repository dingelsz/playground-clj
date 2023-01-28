(ns playground.parse
  (:gen-class)
  (:require [instaparse.core :as insta]))

(def parser
  "Parses a string into a AST"
  (insta/parser (slurp "resources/arithmetic.bnf")))

(defn parse [input]
  (first (parser input)))

