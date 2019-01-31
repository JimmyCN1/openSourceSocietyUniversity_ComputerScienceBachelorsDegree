;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname space-invaders) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/universe)
(require 2htdp/image)
;(require racket/base)
;(require racket/contract/base)
(require web-server/private/timer)

;; Space Invaders


;; Constants:

(define WIDTH  300)
(define HEIGHT 500)

(define SURFACE (- HEIGHT 15))
(define TURRET-HEIGHT (- SURFACE 18))

(define INVADER-X-SPEED 1.5)  ;speeds (not velocities) in pixels per tick
(define INVADER-Y-SPEED 1.5)
(define INVADER-SPAWN-HEIGHT -10)
(define MAX-INVADER 10)

(define TANK-SPEED 2)
(define MISSILE-SPEED 10)

(define HIT-RANGE 10)

(define INVADE-RATE 150)

(define BACKGROUND (empty-scene WIDTH HEIGHT))
(define BLIP (square 0 "solid" "white"))

(define INVADER
  (overlay/xy (ellipse 10 15 "outline" "blue")              ;cockpit cover
              -5 6
              (ellipse 20 10 "solid"   "blue")))            ;saucer

(define TANK
  (overlay/xy (overlay (ellipse 28 8 "solid" "black")       ;tread center
                       (ellipse 30 10 "solid" "green"))     ;tread outline
              5 -14
              (above (rectangle 5 10 "solid" "black")       ;gun
                     (rectangle 20 10 "solid" "black"))))   ;main body

(define TANK-HEIGHT/2 (/ (image-height TANK) 2))

(define MISSILE (ellipse 5 15 "solid" "red"))



;; Data Definitions:

(define-struct game (invaders missiles tank))
;; Game is (make-game  (listof Invader) (listof Missile) Tank)
;; interp. the current state of a space invaders game
;;         with the current invaders, missiles and tank position

;; Game constants defined below Missile data definition

#;
(define (fn-for-game s)
  (... (fn-for-loinvader (game-invaders s))
       (fn-for-lom (game-missiles s))
       (fn-for-tank (game-tank s))))



(define-struct tank (x dir))
;; Tank is (make-tank Number Integer[-1, 1])
;; interp. the tank location is x, HEIGHT - TANK-HEIGHT/2 in screen coordinates
;;         the tank moves TANK-SPEED pixels per clock tick left if dir -1, right if dir 1

(define T0 (make-tank (/ WIDTH 2) 1))   ;center going right
(define T1 (make-tank 50 1))            ;going right
(define T2 (make-tank 50 -1))           ;going left

#;
(define (fn-for-tank t)
  (... (tank-x t) (tank-dir t)))



(define-struct invader (x y dx))
;; Invader is (make-invader Number Number Number)
;; interp. the invader is at (x, y) in screen coordinates
;;         the invader along x by dx pixels per clock tick

(define I1 (make-invader 150 100 1))           ;not landed, moving right
(define I2 (make-invader 150 HEIGHT -1))       ;exactly landed, moving left
(define I3 (make-invader 150 (+ HEIGHT 10) 1)) ;> landed, moving right
(define I4 (make-invader 200 175 1))
(define I5 (make-invader 15 50 1))


#;
(define (fn-for-invader invader)
  (... (invader-x invader) (invader-y invader) (invader-dx invader)))


;; ListOfInvader is one of:
;;  - empty
;;  - (cons Invader ListOfInvader)
;; interp. a list of invaders that are present on screen

(define LOI-1 empty)
(define LOI-2 (cons I1 empty))              ;one invader
(define LOI-3 (cons I1 (cons I2 empty)))    ;two indaders

#;
(define (fn-for-loi loi)
  (cond [(empty? loi) (...)]
        [else (... (first loi)
                   (fn-for-loi (rest loi)))]))

  

(define-struct missile (x y))
;; Missile is (make-missile Number Number)
;; interp. the missile's location is x y in screen coordinates

(define M1 (make-missile 150 300))                       ;not hit U1
(define M2 (make-missile (invader-x I1) (+ (invader-y I1) 10)))  ;exactly hit U1
(define M3 (make-missile (invader-x I1) (+ (invader-y I1)  5)))  ;> hit U1

#;
(define (fn-for-missile m)
  (... (missile-x m) (missile-y m)))


;; ListOfMissile is one of:
;;  - empty
;;  - (cons Missile ListOfMissile)
;; interp. a list of missiles in the game screen

(define LOM-1 empty)
(define LOM-2 (cons M1 empty))
(define LOM-3 (cons M1 (cons M2 empty)))

#;
(define (fn-for-lom lom)
  (cond [(empty? lom) (...)]
        [else (... (first lom)
                   (fn-for-lom (rest lom)))]))

 

(define G0 (make-game empty empty T0))
(define G1 (make-game empty empty T1))
(define G2 (make-game (list I1) (list M1) T1))
(define G3 (make-game (list I1 I2) (list M1 M2) T1))
(define G4 (make-game (list I1 I4 I5) (list M1 M2) T1))


;; Space Invaders



;; =================
;; Functions:

;; Game -> Game
;; start the world with (main G1)
;; 
(define (main game)
  (big-bang game                 ; Game
            (on-tick   tick)     ; Game -> Game
            (to-draw   render)   ; Game -> Image
           ; (stop-when invaded)  ; Invader -> Boolean
            (on-key    control)))  ; Game KeyEvent -> Game

;; Game -> Game
;; produce the next tank position, invaders position and missile positions
(check-expect (tick G3)
              (make-game (cons (make-invader (+ 150 INVADER-X-SPEED) (+ 100 INVADER-Y-SPEED) 1) empty)
                         (cons (make-missile 150 (- 300 MISSILE-SPEED))
                               (cons (make-missile 150 (- 110 MISSILE-SPEED)) empty))
                         (make-tank (+ 50 TANK-SPEED) 1)))

;(define (tick s) false)    ;stub

;template taken from game
(define (tick s)
  (make-game (move-invaders (game-invaders (invader-countdown s)))
             (move-missiles (game-missiles s))
             (move-tank (game-tank s))))


;; ListOfInvader -> ListOfInvader
;; move invaders in list to new x and y coordinates
(check-expect (move-invaders empty) empty)
(check-expect (move-invaders (cons (make-invader 150 100 1)
                                   (cons (make-invader 150 200 1) empty)))
              (cons (make-invader (+ 150 INVADER-X-SPEED) (+ 100 INVADER-Y-SPEED) 1)
                    (cons (make-invader (+ 150 INVADER-X-SPEED) (+ 200 INVADER-Y-SPEED) 1) empty)))

;(define (move-invaders loi) empty)    ;stub

;template taken from ListOfInvader
(define (move-invaders loi)
  (cond [(empty? loi) empty]
        [else
         (if (>= (invader-y (first loi)) HEIGHT)
             (rest loi)
             (cons (move-invader (first loi))
                   (move-invaders (rest loi))))]))


;; Invader -> Invader
;; update position of single invader
(check-expect (move-invader (make-invader 150 100 1))
                            (make-invader (+ 150 (* INVADER-X-SPEED 1)) (+ 100 INVADER-Y-SPEED) 1))          ;down right
(check-expect (move-invader (make-invader 150 100 -1))
                            (make-invader (+ 150 (* INVADER-X-SPEED -1)) (+ 100 INVADER-Y-SPEED) -1))        ;down left
(check-expect (move-invader (make-invader 0 100 -1))
                            (make-invader (+ 0 (* INVADER-X-SPEED 1)) 100  1))                               ;bump left wall
(check-expect (move-invader (make-invader WIDTH 100  1))
                            (make-invader (+ WIDTH (* INVADER-X-SPEED -1)) 100 -1))                          ;bump right wall
(check-expect (move-invader (make-invader 150 HEIGHT 1))
                            (make-invader (+ 150 (* INVADER-X-SPEED 1)) (+ HEIGHT INVADER-Y-SPEED) 1))                                                    ;floor reached

;(define (move-invader invader) false)    ;stub

;template taken from invader
(define (move-invader invader)
  (cond [(<= (invader-x invader) 0)
         (make-invader (+ (invader-x invader) (* INVADER-X-SPEED 1)) (invader-y invader) (* (invader-dx invader) -1))]
        [(>= (invader-x invader) WIDTH)
         (make-invader (+ (invader-x invader) (* INVADER-X-SPEED -1)) (invader-y invader) (* (invader-dx invader) -1))]
;        [(>= (invader-y invader) HEIGHT)
;         (invaded (make-invader (invader-x invader) (invader-y invader) (invader-dx invader)))]   ;invader reaches the ground
        [else
         (make-invader (+ (invader-x invader) (* INVADER-X-SPEED (invader-dx invader)))
                       (+ (invader-y invader) INVADER-Y-SPEED)
                       (invader-dx invader))]))


;; ListOfMissile -> ListOfMissile
;; produce the next x and y coordinates of all the missiles on the screen
(check-expect (move-missiles empty) empty)
(check-expect (move-missiles (cons (make-missile 150 300)
                    (cons (make-missile 200 250) empty)))                                                           ;; two fired missiles moving upwards
              (cons (make-missile 150 (- 300 MISSILE-SPEED))
                    (cons (make-missile 200 (- 250 MISSILE-SPEED)) empty)))
(check-expect (move-missiles (cons (make-missile 150 -10) empty))
              empty)

;(define (move-missiles lom) false)    ;stub

;template taken from ListOfMissile
(define (move-missiles lom)
  (cond [(empty? lom) empty]
        [else
         (if (< (missile-y (first lom)) 0)
             (rest lom)
             (cons (move-missile (first lom))
                   (move-missiles (rest lom))))]))


;; Missile -> Missile
;; move a single missile to the correct x y coordinates
(check-expect (move-missile (make-missile 150 200))            ; normal missile travel
              (make-missile 150 (- 200 MISSILE-SPEED)))

;(define (move-missile m) false)    ;stub

;template taken from Missile
(define (move-missile m)
  (make-missile (missile-x m) (- (missile-y m) MISSILE-SPEED)))



;; Tank -> Tank
;; produce new tank x-coordinates
(check-expect (move-tank T1)
              (make-tank (+ 50 (* TANK-SPEED 1)) 1))     ;moving right
(check-expect (move-tank T2)
              (make-tank (+ 50 (* TANK-SPEED -1)) -1))   ;moving left
(check-expect (move-tank (make-tank WIDTH 1))            ;hit right wall
              (make-tank (+ WIDTH (* TANK-SPEED -1)) -1))
(check-expect (move-tank (make-tank 0 -1))               ;hit left wall
              (make-tank (+ 0 (* TANK-SPEED 1)) 1))
              

;(define (move-tank t) false) ;stub

(define (move-tank t)
  (cond [(<= (tank-x t) 0)
         (make-tank (+ (tank-x t) (* TANK-SPEED 1)) (* (tank-dir t) -1))]
        [(>= (tank-x t) WIDTH)
         (make-tank (+ (tank-x t) (* TANK-SPEED -1)) (* (tank-dir t) -1))]
        [else
         (make-tank (+ (tank-x t) (* TANK-SPEED (tank-dir t))) (tank-dir t))]))


;; ListOfInvaders ListOfMissiles Tank -> Image
;; render the players tank, the invaders and the missiles at their correct x any y coordinates 
(check-expect (render G2)                                     ;(1 tank, 1 missile, 1 invader)
              (place-image
               INVADER 150 100
               (place-image
                MISSILE 150 300
                (place-image
                 TANK 50 SURFACE BACKGROUND))))
(check-expect (render G3)                                     ;(1 tank, 2 missiles, 2 invaders)
              (place-image
               INVADER 150 100
               (place-image
                INVADER 150 HEIGHT
                (place-image
                 MISSILE 150 300
                 (place-image
                  MISSILE (invader-x I1) (+ (invader-y I1) 10)
                  (place-image
                   TANK 50 SURFACE BACKGROUND))))))

;(define (render loi lom tank) BACKGROUND)    ;stub

;template taken from Game
(define (render s)
  (place-image
   (render-invaders (game-invaders s) (game-missiles s) (game-tank s))
   (/ WIDTH 2) (/ HEIGHT 2)
   BACKGROUND))


;; ListOfInvader -> Image
;; render list of invaders onto BACKGROUND
(check-expect (render-invaders empty empty T1)
              (place-image
               TANK 50 SURFACE BACKGROUND))
(check-expect (render-invaders (list I1) (list M1) T1)
              (place-image
               INVADER 150 100
               (place-image
                MISSILE 150 300
                (place-image
                 TANK 50 SURFACE BACKGROUND))))
(check-expect (render-invaders (list I1 I2) (list M1 M2) T1)
              (place-image
               INVADER 150 100
               (place-image
                INVADER 150 HEIGHT
                (place-image
                 MISSILE 150 300
                 (place-image
                  MISSILE (invader-x I1) (+ (invader-y I1) 10)
                  (place-image
                   TANK 50 SURFACE BACKGROUND))))))

;(define (render-invaders loi) BACKGROUND)    ;stub

;template taken from ListOfInvaders

(define (render-invaders loi lom tank)
  (cond [(empty? loi) (render-missiles lom tank)]
        [else
         (render-invader (first loi)
                         (render-invaders (rest loi) lom tank))]))


;; Invader Image -> Image
;; render image of invader onto BACKGROUND
(check-expect (render-invader I1 BACKGROUND)
              (place-image INVADER 150 100 BACKGROUND))

;(define (render-invader invader img) false)    ;stub

;template taken from invader
(define (render-invader invader img)
  (if (false? (invader-x invader))
      invader
      (place-image
       INVADER (invader-x invader) (invader-y invader) img)))


;; ListOfMissile -> Image
;; render list of missile onto BACKGROUND
(check-expect (render-missiles empty T1)
              (place-image
               TANK 50 SURFACE BACKGROUND))
(check-expect (render-missiles (list M1) T1)
              (place-image
               MISSILE 150 300
               (place-image
                TANK 50 SURFACE BACKGROUND)))
(check-expect (render-missiles (list M1 M2) T1)
              (place-image
               MISSILE 150 300
               (place-image
                MISSILE (invader-x I1) (+ (invader-y I1) 10)
                (place-image
                 TANK 50 SURFACE BACKGROUND))))

;(define (render-missiles lom) false)    ;stub

;template taken from ListOfMissile
(define (render-missiles lom tank)
  (cond [(empty? lom) (render-tank tank)]
        [else
         (render-missile (first lom)
                         (render-missiles (rest lom) tank))]))


;; Missile Image -> Image
;; render MISSILE onto background
(check-expect (render-missile M1 BACKGROUND)
              (place-image
               MISSILE 150 300 BACKGROUND))
;(check-expect (render-missile (make-missile 150 -10) BACKGROUND)
;              empty)

;(define (render-missile missile img) false)    ;stub

;template taken from Missile
(define (render-missile missile img)
  (place-image
   MISSILE (missile-x missile) (missile-y missile) img))


;; Tank -> Image
;; render image of tank onto BACKGROUND
(check-expect (render-tank T1)
              (place-image
               TANK 50 SURFACE BACKGROUND))

;(define (render-tank tank) false)    ;stub

;template taken from Tank
(define (render-tank t)
  (place-image
   TANK (tank-x t) SURFACE BACKGROUND))


;; Game KeyEvent -> Game
;; shoot a missile and control the tank
(check-expect (control G1 "up")
              G1)
(check-expect (control G1 " ")
              (make-game
               empty
               (cons (make-missile 50 467) empty)
               (make-tank 50 1)))
(check-expect (control (make-game empty empty (make-tank 50  1)) "left")
              (make-game empty empty (make-tank 50 -1)))
(check-expect (control (make-game empty empty (make-tank 50 -1)) "right")
              (make-game empty empty (make-tank 50 1)))
              
;(define (control s ke) false)    ;stub

;template taken from Game
(define (control s ke)
  (cond [(key=? ke " ")
         (make-game (game-invaders s)
                    (create-missile (game-missiles s) (game-tank s))
                    (game-tank s))]
        [(or (key=? ke "left") (key=? ke "right"))
         (direction-change s ke)]
        [else
         s]))


;; Game KeyEvent -> Game
;; change direction of tank
(check-expect (direction-change G1 "up")
              G1)
(check-expect (direction-change (make-game empty empty (make-tank 50  1)) "left")
              (make-game empty empty (make-tank 50 -1)))
(check-expect (direction-change (make-game empty empty (make-tank 50 -1)) "right")
              (make-game empty empty (make-tank 50 1)))
              
;(define (direction-change s ke) false)    ;stub

;template taken from Game
(define (direction-change s ke)
  (if (or (and (key=? ke "left" ) (= (tank-dir (game-tank s))  1))
          (and (key=? ke "right") (= (tank-dir (game-tank s)) -1)))
      (make-game (game-invaders s)
                 (game-missiles s)
                 (make-tank (tank-x (game-tank s)) (* (tank-dir (game-tank s)) -1)))
      (make-game (game-invaders s)
                 (game-missiles s)
                 (game-tank s))))


;; ListOfMissile -> ListOfMissile
;; instantiate a bullet when the space key is pressed
;;   and add the bullet to the list of missile
(check-expect (create-missile empty T1)
              (cons (make-missile 50 TURRET-HEIGHT) empty))
(check-expect (create-missile LOM-2 T1)
                    (cons M1 (cons (make-missile 50 TURRET-HEIGHT) empty)))
(check-expect (create-missile LOM-3 T1)
              (cons M1 (cons M2 (cons (make-missile 50 TURRET-HEIGHT) empty))))

;(define (create-missile lom tank) false)    ;stub

;template taken from ListOfMissile
(define (create-missile lom tank)
  (cond [(empty? lom) (cons (make-missile (tank-x tank) TURRET-HEIGHT) empty)]
        [else
         (append lom
                 (cons (make-missile (tank-x tank) TURRET-HEIGHT) empty))]))


;; Invader -> Boolean
;; stop the game when the surface has been invaded (when an invader touches the ground)
;(check-expect (invaded (make-invader 150 HEIGHT 1))
;              true)

;(define (invaded invader) false)     ;stub

;template taken from Invader
#;
(define (invaded invader)
  (if (= (invader-y invader) HEIGHT)
      true
      false))


;; Game -> Game
;; random generation of INVADER
(check-expect (invader-countdown G3)                                                      ;when random != INVADE-RATE
              G3)
(check-expect (invader-countdown G3)
              (make-game (cons (make-invader (random WIDTH) INVADER-SPAWN-HEIGHT 1)       ;when random = INVADE-RATE
                               (cons I1
                                     (cons I2 empty)))
                         (cons M1 (cons M2 empty))
                         T1))

;(define (invader-countdown s) false)    ;stub

;template taken from ListOfInvader
(define (invader-countdown s)
  (cond [(and (= (random (+ INVADE-RATE 1)) INVADE-RATE)
              (< (length (game-invaders s)) MAX-INVADER))
         (make-game (game-invaders (invader-countdown (spawn-invaders s)))
                    (game-missiles s)
                    (game-tank s))]
        [else
         s]))


;; Game -> Game
;; generate new invaders at x width above the screen
(check-expect (spawn-invaders G1)
              (make-game (cons (make-invader (random WIDTH) INVADER-SPAWN-HEIGHT 1) empty)
                         empty
                         T1))
(check-expect (spawn-invaders G3)
              (make-game (cons (make-invader (random WIDTH) INVADER-SPAWN-HEIGHT 1)
                               (cons I1 (cons I2 empty)))
                         (cons M1 (cons M2 empty))
                         T1))
             
;(define (spawn-invaders s) empty)    ;stub

;template take from ListOfInvader
(define (spawn-invaders s)
  (make-game (cons (make-invader
                    (random WIDTH)
                    INVADER-SPAWN-HEIGHT
                    1)
                   (game-invaders s))
             (game-missiles s)
             (game-tank s)))











