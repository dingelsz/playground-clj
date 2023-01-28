;; https://clojure-doc.org/articles/ecosystem/java_jdbc/using_sql/
(ns playground.db
  (:gen-class)
  (:require [clojure.java.jdbc :as j]))

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "resources/db.sqlite"})

(j/db-do-commands db "CREATE TABLE IF NOT EXISTS calc (expr, result INT);")

(defn insert-calc [expr result]
  (j/insert! db :calc {:expr expr :result result}))

(defn query-calc [expr]
  (j/query db ["SELECT expr, result FROM calc WHERE expr = ?" expr]))

(defn query-calc-result [expr]
  (let [results (j/query db ["SELECT result FROM calc WHERE expr = ?" expr])]
    (get (first results) :result)
    ))

(query-calc-result "1+2")
