(ns db-manager.routes
  (:require [clojure.data.json :as json]))

(def ping-route
  ["/ping"
   {:name :ping
    :get (fn [_]
           {:status 200
            :body "pong"})}])

(def crud-routes
  ; make a route that takes json body with values "x" and "y", and returns the sum
  ["/post" {:post {:parameters {:body {:x int?
                                       :y int?}}
                   :responses {200 {:body {:sum int?}}} 
                   
                   :handler (fn [{{{:keys [x y]} :body} :parameters}]
                              {:status 200
                               :body {:sum (+ x y)}})}}])