;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname week2DesignQuiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;; Image Image -> Boolean
;; produce "true" if the first image provided has a larger area than the second image provided

(check-expect (bigger? (rectangle 30 30 "solid" "blue") (rectangle 30 20 "solid" "red")) true)
(check-expect (bigger? (rectangle 20 20 "solid" "blue") (rectangle 30 20 "solid" "red")) false)
(check-expect (bigger? (rectangle 40 40 "solid" "blue") (rectangle 40 40 "solid" "red")) false)

;(define (bigger? img1 img2) false)    ;stub

;(define (bigger? img1 img2)           ;template
;  (... img1 img2))

(define (bigger? img1 img2)
  (if (> (* (image-width img1) (image-height img1)) (* (image-width img2) (image-height img2)))
      true
      false))