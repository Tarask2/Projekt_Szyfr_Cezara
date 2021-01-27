(ns fp.cezara)
(defn kod_Cezara  [coll c]
  (if (Character/isLetter c)
    (let [v (int c)
          base (if (>= v (int \a))
                 (int \a)
                 (int \A))

          coll (mod coll 26)]
      (char (+ (mod (+ (- v base) coll) 26)
               base)))
    c))

(defn encrypt [coll text]
  (apply str (map #(kod_Cezara  coll %) text)))

(defn decrypt [coll text]
  (encrypt (- 26 coll) text))


(let [text " My first project to clojure Hello World"
      enc (encrypt 5 text)]
  (print "Original text:" text "\n")
  (print "Encryption:" enc "\n")
  (print "Decryption:" (decrypt 5 enc) "\n"))


;Taras Kushnir ,Dawid Nowakowski ,Sebastian Piątkowski


