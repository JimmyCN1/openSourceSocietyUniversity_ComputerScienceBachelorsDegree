;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname localScope) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))


(local [(define a 1)
        (define b 2)]
  (+ a b))


(local [(define p "accio ")
        (define (fetch n) (string-append p n))]

  (fetch "portkey"))

a

(fetch "portkey")