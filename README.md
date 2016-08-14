# clj-isbn

[![Clojars Project](https://img.shields.io/clojars/v/clj-isbn.svg)](https://clojars.org/clj-isbn)

A simple ISBN utility library for Clojure.

## Installation

clj-isbn is hosted in [Clojars](https://clojars.org/clj-isbn).

Using Leiningen, add clj-isbn as a dependency to your project's project.clj:

```clojure
[clj-isbn "0.0.2"]
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

And vice versa:

```clojure
(isbn/isbn13->isbn10 "978-91-501-1334-1")
; "9150113348"
```


To calculate check digits:

```clojure
(isbn/isbn10-checkdigit "85-359-0277")
; 5
(isbn/isbn13-checkdigit "978-951-98548-9")
; 2
```

To get the publisher zone:

```clojure
(isbn/publisher-zone "978-91-501-1334-1")
; "Sweden"
```

TODO: ISBN hyphenation.
