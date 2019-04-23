(ns midnightoil.clojureapplied.ch2.orders)

(defn compare-authors-badly [s1 s2]
  (compare (:lname s1) (:lname s2))) ;; --NOTE: Bad way

(defn compare-author [s1 s2]
  (letfn [(project-author [author]
            ((juxt :lname :fname) author))]
    (compare (project-author s1) (project-author s2))))

(sorted-set-by compare-author
               {:fname "Jeff" :lname "Smith"}
               {:fname "Bill" :lname "Smith"})


(defn new-orders [] [])

(defn add-order [orders order]
  (conj orders order))

;;(defn cook-order [orders]
 ;; (cook (first orders)) (rest orders))



(def new-orders clojure.lang.PersistentQueue/EMPTY)

(defn hello [x]
  (println x))

(hello "jamal")
