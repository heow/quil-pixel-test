(ns quil-pixel-test.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/set-state! :image (q/load-image "resources/fire0.png")))

;(enable-console-print!)

(defn draw-state []
  (q/background 255)
  (q/fill 0)
  (q/text-size 20)
  (q/text (str "DISPLAY IMAGE IN " (- 5 (int (/ (q/millis) 1000))) " SECONDS"
               "\nimage width: " (.-width  (q/state :image))
               "\nimage height:" (.-height (q/state :image))
               "\nimage loaded:" (.-loaded (q/state :image)) ) 
          10 200)
  (if (and
       (> (q/millis) 5000)
       (not (zero? (.-width (q/state :image)))))
    (let [gr (q/state :image)
          x (q/mouse-x)
          y (q/mouse-y)
          pixel (q/get-pixel gr x y)] ;; <--- FAIL?
      (q/image gr 0 0)
      (q/text (str "pos: [" x ", " y "], pixel: " pixel) 20 (+ 20 (.-height gr)) )
      (q/fill 255))))

(q/defsketch quil-pixel-test
  :host "quil-pixel-test"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :draw draw-state
  :renderer :p3d
)
