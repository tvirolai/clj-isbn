(ns clj-isbn.core-test
  (:require [clojure.test :refer :all]
            [clj-isbn.core :refer :all]))

(deftest conversion
  (testing "ISBN-10 -> ISBN-13 conversion"
   (is (= "9780306406157" (isbn10->isbn13 "0-306-40615-2"))))
  (testing "ISBN-13 -> ISBN-13 conversion"
    (is (= "9520102817" (isbn13->isbn10 "978-952-01-0281-4")))))

(deftest validation
  (testing "A valid ISBN should pass"
    (is (true? (is-valid? "9780306406157"))))
  (testing "An invalid ISBN should not pass"
    (is (false? (is-valid? "95Ö-23-2078-9"))))
  (testing "An invalid ISBN should not pass"
    (is (false? (is-valid? "951-23-2078-1")))))

(deftest check-digits
  (testing "ISBN-10 check digit generation"
    (is (= 9 (isbn10-checkdigit "951-23-2078"))))
  (testing "ISBN-13 check digit generation"
    (is (= 2 (isbn13-checkdigit "978-951-98548-9"))))
  (testing "ISBN-13 check digit generation"
    (is (= 7 (isbn13-checkdigit "978-952-93-5178")))))

(deftest hyphenation
  (testing "ISBN hyphenation"
    (is (= "978-952-93-5178-7" (hyphenate "9789529351787")))
    (is (= "0-9796163-1-X" (hyphenate "097961631X")))))
