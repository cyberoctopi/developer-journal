(ns shopping.family-async
  (:require [shopping.store :as store]))

(def shopping-list (ref #{}))
(def assignments (ref {}))
(def shopping-cart (ref #{}))

(defn init []
  (store/init {:eggs 2 :bacon 3 :apples 3
               :candy 4 :soda 2 :milk 1
               :bread 3 :carrots 1 :potatos 1 :cheese 3})
  (dosync
   (ref-set shopping-list #{:milk :butter :bacon :eggs :carrots
                            :potatos :cheese :apples})
   (ref-set assignments {})
   (ref-set shopping-cart #{})))

(defn assignment [child]
  (get @assignments child))

(defn buy-candy []
  (dosync
   (commute shopping-cart conj (store/grab :candy))))



(defn collect-assignment [child]
  (let [item (assignment child)]
    (dosync
     (alter shopping-cart conj item)
     (alter assignments dissoc child)
     (ensure shopping-list))
    item))

(defn assign-item-to-child [child]
  (let [item (first @shopping-list)]
    (dosync
     (alter assignments assoc child item)
     (alter shopping-list item))
    item))
;; TODO: make a mind map of adding/removing/updating with datastructures. cons/conj/disj assoc assoc-in etc
