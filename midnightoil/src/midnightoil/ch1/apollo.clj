(ns midnightoil.ch1.apollo)

(defn make-mission
  [name system launched manned? opts]
  (let [{:keys [cm-name ;;command module
                lm-name ;;lunar module
                orbits
                evas]} opts] ,,,))

(def apollo-4
  (make-mission "Apollo 4"
                "Saturn V"
                #inst "1967-11-09T12:00:01-00:00"
                false
                {:orbits 3}))

(def mission-defaults {:orbits 0, :evas 0})

(defn make-mission
  [name system launched manned? opts]
  (let [{:keys [cm-name ;; command module
                lm-name ;; lunar module
                orbits
                evas
                ]} (merge mission-defaults opts)] ,,,))
;; NOTE: another method of addint optional args is to destructure the 'varargs' sequence as a map...using an extra &
(defn make-mission
  [name system launched manned? & opts]
 (let [{:keys [cm-name ;; command module
               lm-name ;; lunar module
               orbits
               evas]} opts] ,,,))

(def apollo-11 (make-mission "Apollo 11"
                             "Saturn V"
                             #inst "1969-07-16T13:32:00-00:00" true
                             :cm-name "Columbia"
                             :lm-name "Eagle"
                             :orbit 30
                             :evas 1))

(apollo-11)

(defn euclidean-norm [ecc-vector],,,)
(defrecord Planet [name moons volume mass aphelion perihelion orbital-eccentricity])


