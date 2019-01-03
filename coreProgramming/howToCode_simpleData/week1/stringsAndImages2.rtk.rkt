;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname stringsAndImages2.rtk) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;(circle 10 "solid" "red")
;(rectangle 30 60 "outline" "blue")

;(text "hello" 24 "orange")

(overlay (circle 10 "solid" "red")
       (circle 20 "solid" "yellow")
       (circle 30 "solid" "green"))

(overlay/offset (overlay/offset (overlay/offset (triangle 80 "outline" "black")
                                                0 15
                                                (ellipse 40 20 "outline" "black"))
                                0 15
                                (ellipse 7 7 "solid" "white"))
                0 15
                (ellipse 20 20 "solid" "black"))