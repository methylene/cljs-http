(defproject cljs-http "0.1.2-SNAPSHOT"
  :description "A ClojureScript HTTP library."
  :url "http://github.com/r0man/cljs-http"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[noencore "0.1.6"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 [org.clojure/core.async "0.1.0-SNAPSHOT"]]
  :profiles {:dev {:plugins [[com.cemerick/austin "0.1.1"]
                             [com.cemerick/clojurescript.test "0.1.0"]]}}
  :plugins [[lein-cljsbuild "0.3.2"]]
  :hooks [leiningen.cljsbuild]
  :min-lein-version "2.0.0"
  :lein-release {:deploy-via :clojars}
  :cljsbuild {:builds [{:compiler {:output-to "target/cljs-http-debug.js"}
                        :source-paths ["src"]}
                       {:compiler {:output-to "target/cljs-http.js"
                                   :optimizations :advanced
                                   :pretty-print false}
                        :source-paths ["src"]}
                       {:compiler {:output-to "target/cljs-http-test.js"
                                   :optimizations :advanced
                                   :pretty-print true}
                        :source-paths ["test"]}]
              :repl-listen-port 9000
              :repl-launch-commands
              {"chromium" ["chromium" "http://localhost:9000/"]
               "firefox" ["firefox" "http://localhost:9000/"]}
              :test-commands {"unit-tests" ["phantomjs" :runner "target/cljs-http-test.js"]}}
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"})
