# clj-isbn

A simple ISBN utility library for Clojure.

## Installation

clj-isbn is available from [Clojars](https://clojars.org/clj-isbn).

Using Leiningen, add clj-isbn as a dependency to your project's project.clj:

```clojure
[clj-isbn "0.0.1"]
```

Then require it into your namespace:

```clojure
(ns foo.bar
 (require [clj-isbn.core :as isbn]))
```

or

```clojure
(ns foo.bar
 (require [clj-isbn.core :refer :all]))
```

## Usage

To validate an ISBN:

```clojure
(isbn/is-valid? "85-359-0277-5")
; true
```

To convert an ISBN-10 to ISBN-13:

```clojure
(isbn/isbn10->isbn13 "85-359-0277-5")
; "9788535902778"
```

To calculate check digits:

```clojure
(isbn/isbn10-checkdigit "85-359-0277")
; 5
(isbn/isbn13-checkdigit "978-951-98548-9")
; 2
```

TODO: ISBN hyphenation.
