(defproject quil-pixel-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.562"]
                 [quil "2.6.0"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :cljsbuild {:builds [{:source-paths ["src"]
                        :compiler
                        {:output-to "js/main.js"
                         :output-dir "out"
                         :main "quil-pixel-test.core"
                         :optimizations :none
                         :pretty-print true}}]}
 
)
