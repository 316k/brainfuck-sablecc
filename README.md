# brainfuck-sablecc

A Brainfuck -> JavaScript compiler written to experiment with SableCC

## Build

Pretty straigtforward, provided that you have [`sablecc`](http://www.sablecc.org/), `javac` and `d8` already installed.

```bash
user@pc$ make
# outputs stuff
user@pc$ java bf.Main < helloWorld.bf > helloWorld.js
...
user@pc$ d8 helloWorld.js
Hello World!
```
