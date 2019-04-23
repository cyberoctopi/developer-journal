(ns midnightoil.ch1.modeling)

(def earth {:name "Earth"
            :moons 1
            :volume 1.08321e12
            :mass 5.97219e24
            :aphelion 152098232
            :perihelion 147098290
            :type :Planet})


(defrecord Planet [name
                   moons
                   volume
                   aphelion
                   perihelion])

;; Positional factory function
(def earth
  (->Planet "Earth" 11.08321e12 5.97219e24 152098232 147098290))

;; NOTE: you can also create it as a map
(def earth
  (map->Planet {:name "Earth"
                :moons 1
                :volume 1.08321e12
                :mass 5.97219e24
                :aphelion 152098232
                :perihelion 147098290
                :type :Planet}))

earth

(def box [1 "two" 3 55])
box




