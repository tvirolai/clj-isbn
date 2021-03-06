(defproject clj-isbn "1.1.0"
  :description "An ISBN utility library"
  :url "https://github.com/tvirolai/clj-isbn"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "RELEASE"]]
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :sign-releases false}]]
  :plugins [[lein-cloverage "1.1.1"]])
