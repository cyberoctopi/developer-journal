(ns midnightoil.ch1.recipe)

(defrecord Recipe
    [name ;; string
     author ;; recipe creator
     description ;;string
     ingredients ;; list of ingredients
     steps ;; sequence
     servings ;; number of servings
     ])

(defrecord Person
    [fname ;; first name
     lname ;; last name
     ])

