(ns shopping.store)



(def inventory (atom {}))

(defn no-negative-values?
  "check values of a map for a negative value"
  [m]
  (not-any? neg? (vals m)))

(defn in-stock?
  "check if an item is in stock"
  [item]
  (let [cnt (item @inventory)]
    (and (pos? cnt))))

(defn init
  "Set up store with inventory"
  [items]
  (set-validator! inventory no-negative-values?)
  (swap! inventory items))

(defn grab
  "grab an item from the shelves"
  [item]
  (if (in-stock? item)
    (swap! inventory update-in [item] dec)))

(defn stock
  "stock an item on the shelves"
  [item]
  (swap! inventory update-in [item] inc))



(declare sold-items)

(defn restock-order
  "a watch to restock an item"
  [k r ov nv]
  (doseq [item (for [kw (keys ov)
                     :when (not= (kw ov) (kw nv))] kw)]
    (swap! sold-items update-in [item] (fnil inc 0))
    (println "need to restock item")))

(defn init-with-restock
  "set up store with inventory"
  [m]
  (def inventory (atom m))
  (def sold-items (atom {}))
  (set-validator! inventory no-negative-values?)
  (add-watch inventory :restock restock-order))

(defn restock-all
  "restock all items sold"
  []
  (swap! inventory #(merge-with + % @sold-items))
  (reset! sold-items {}))


(init-with-restock {:apples 1 :bacon 3 :milk 2})
