(ns clj-isbn.core-test
  (:require [clojure.test :refer :all]
            [clj-isbn.core :refer :all]))

(deftest conversion
  (testing "ISBN-10 -> ISBN-13 conversion"
   (is (= "9780306406157" (isbn10->isbn13 "0-306-40615-2"))))
   (is (= nil (isbn10->isbn13 "0-306-40615-2324")))
  (testing "ISBN-13 -> ISBN-13 conversion"
    (is (= "9520102817" (isbn13->isbn10 "978-952-01-0281-4")))))

(deftest validation
  (testing "A valid ISBN should pass"
    (is (true? (is-valid? "9780306406157"))))
    (is (true? (is-valid? "097961631X")))
  (testing "An invalid ISBN should not pass"
    (is (false? (is-valid? "95Ö-23-2078-9"))))
    (is (false? (is-valid? "951-23-2078-1"))))

(deftest check-digits
  (testing "ISBN-10 check digit generation"
    (is (= 9 (isbn10-checkdigit "951-23-2078")))
    (is (= "X" (isbn10-checkdigit "097961631X"))))
  (testing "ISBN-13 check digit generation"
    (is (= 2 (isbn13-checkdigit "978-951-98548-9"))))
  (testing "ISBN-13 check digit generation"
    (is (= 7 (isbn13-checkdigit "978-952-93-5178")))))

(deftest hyphenation
  (testing "ISBN hyphenation"
    (is (= "978-952-93-5178-7" (hyphenate "9789529351787")))
    (is (= "0-9796163-1-X" (hyphenate "097961631X")))
    (is (= "978-952-216-546-6" (hyphenate "9789522165466")))
    (is (= "978-3-86312-025-2" (hyphenate "9783863120252")))
    (is (= "978-3-7995-9123-2" (hyphenate "9783799591232")))
    (is (= nil (hyphenate "9783799591235")))
    (is (= nil (hyphenate "YO BABEZ!")))
    (is (= "3-7995-9123-0" (hyphenate "3799591230")))
    (is (= true (correctly-hyphenated? "978-952-68574-1-1")))
    (is (= false (correctly-hyphenated? "9781472465689")))))

(deftest publisherzone
  (testing "Publisher zone function"
    (is (= "German language" (publisher-zone "9783799591232")))
    (is (= "English language" (publisher-zone "097961631X")))
    (nil? (publisher-zone "97837995911111"))))
