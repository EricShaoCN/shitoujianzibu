(ns shitoujianzibu.core)

(defn read-guess []
  (println "请出拳：s石头 j剪子 b布。")
  (let [user-input (read-line)]
    (when (#{"s" "j" "b"} user-input)
      user-input)))

(defn qian-or-hou-win [qian hou]
  (let [geusses [qian hou]]
    (condp = geusses
      ["s" "s"] 0
      ["j" "j"] 0
      ["b" "b"] 0
      ["s" "j"] 1
      ["s" "b"] 2
      ["j" "b"] 1
      ["j" "s"] 2
      ["b" "s"] 1
      ["b" "j"] 2
      )))

(defn show-hand []
  (let [user-hand (read-guess)
        ai-hand (rand-nth ["s" "j" "b"])
        winner-id (qian-or-hou-win user-hand ai-hand)]
    (println "人类出拳:" user-hand)
    (println "AI出拳:" ai-hand)
    (condp = winner-id
      0 (println "平局")
      1 (println "人类赢")
      2 (println "AI赢"))))

(defn start-game []
  (loop []
    (show-hand)
    (recur)))

#_(do
    (start-game))
