(ns midnightoil.clojureapplied.ch2.update
  (:require [medley.core :refer (map-keys)]))

(defn keywordize-entity
  [entity]
  (map-keys keyword entity))

(keywordize-entity {"name" "Earth"
                    "moon" 1
                    "volume" 1.08321e12
                    "mass" 5.97219e24})

(def earth {:name "Earth" :moons 1})

(get earth :name)
(earth :name)
(:name earth)


