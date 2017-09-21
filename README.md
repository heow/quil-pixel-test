# quil-pixel-test

A Quil sketch designed to highlight the issue of getting pixel values at runtime.  It works great as an Applet but exhibits bizarre behavior based on browser and location (local or remote).

| BROWSER         | LOCAL    | REMOTE |
|-----------------|----------|--------|
| OSX Chrome 60   | **FAIL** | ok     |
| OSX Firefox 55  | ok       | ok     |
| OSX Vivaldi 1.3 | **FAIL** | ok     |
| Safari 9.1.3    | ok       | ok     |

## Remote Test

[Simply click here](http://45.55.82.27/quil-pixel-test/) and in 5 seconds you will or will not see an image.

## Local Test

1. Unzip this file
2. Open the index.html with a browser
3. report your findings to me

## Example Screenshots

### Failure
![chrome](resources/chrome-example.png)

### Success
![firefox](resources/ff-example.png)

## Build it Yourself

  $ ./cljs-autobuild.sh
  
Open [index.html](index.html) in all the browsers.
