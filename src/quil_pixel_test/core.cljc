(ns quil-pixel-test.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

;(defn setup []
;  ; Set frame rate to 30 frames per second.
;  (q/frame-rate 30)
;  ; Set color mode to HSB (HSV) instead of default RGB.
;  (q/color-mode :hsb)
;  ; setup function returns initial state. It contains
;  ; circle color and position.
;  {:color 0
;   :angle 0})
;
;(defn update-state [state]
;  ; Update sketch state by changing circle color and position.
;  {:color (mod (+ (:color state) 0.7) 255)
;   :angle (+ (:angle state) 0.1)})
;
;(defn draw-state [state]
;  ; Clear the sketch by filling it with light-grey color.
;  (q/background 240)
;  ; Set circle color.
;  (q/fill (:color state) 255 255)
;  ; Calculate x and y coordinates of the circle.
;  (let [angle (:angle state)
;        x (* 150 (q/cos angle))
;        y (* 150 (q/sin angle))]
;    ; Move origin point to the center of the sketch.
;    (q/with-translation [(/ (q/width) 2)
;                         (/ (q/height) 2)]
;      ; Draw the circle.
;      (q/ellipse x y 100 100))))
;
;(comment quil/defsketch mccarthy-animation
;  :host (:host config/sketch-opts)
;  :size (:size config/sketch-opts)
;  :setup setup
;  :update update-state
;  :no-start (:no-start config/sketch-opts)
;  :draw draw-state
;  :title (:title config/sketch-opts)
;  :middleware [quilm/fun-mode])
;
;(q/defsketch quil-pixel-test
;  :title "You spin my circle right round"
;  :size [500 500]
;  ; setup function called only once, during sketch initialization.
;  :setup setup
;  ; update-state is called on each iteration before draw-state.
;  :update update-state
;  :draw draw-state
;  :features [:keep-on-top]
;  ; This sketch uses functional-mode middleware.
;  ; Check quil wiki for more info about middlewares and particularly
;  ; fun-mode.
;  :no-start true
;  :middleware [m/fun-mode])

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
