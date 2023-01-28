(ns playground.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [playground.calculator]))

(defroutes app
  (GET "/*" {query :query-string} (str (playground.calculator/calculate-cached query)))
  (route/not-found "<h1>Page not found</h1>"))

(defn -main [& args]
  (jetty/run-jetty app
                   {:port 3000
                    :join? true}))

