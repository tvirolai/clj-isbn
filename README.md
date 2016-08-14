# clj-isbn

[![Clojars Project](https://img.shields.io/clojars/v/clj-isbn.svg)](https://clojars.org/clj-isbn)

A simple ISBN utility library for Clojure.

## Installation

clj-isbn is hosted in [Clojars](https://clojars.org/clj-isbn).

Using Leiningen, add clj-isbn as a dependency to your project's project.clj:

```clojure
[clj-isbn "0.0.6"]
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

The conversion functions return the new ISBN codes without hyphens. You have to call hyphenation function separately if you need them:

```clojure
(isbn/hyphenate "9783799591232")
; "978-3-7995-9123-2"
(isbn/hyphenate (isbn/isbn10->isbn13 "097961631X"))
; "978-0-9796163-1-0"
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

It is also possible to extract the different components of an ISBN code:

```clojure
(isbn/get-prefix "9789529351787")
; "978-952"
(isbn/get-registrant-element "9789529351787")
; "93"
(isbn/get-publication-element "9789529351787")
; "5178"
(isbn/get-checkdigit "9789529351787")
; "7"
```
