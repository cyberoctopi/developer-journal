(ns midnightoil.clojureapplied.ch2.search)

(defn contains-val? [coll val]
  (reduce
   (fn [ret elem]
     (if (= val elem)
       (reduced true) ret))
   false coll))

(def units [:lb :oz :kg])

(contains-val? units :oz)
