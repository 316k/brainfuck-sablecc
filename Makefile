# assumes sablecc script is on your PATH

#.PHONY bf

# to compile the code
bf: clean grammar
	javac bf/*.java bf/*/*.java

# to generate the compiler code
grammar: bf.sablecc
	sablecc bf.sablecc

clean:	
	rm -rf bf/*~ bf/*.class bf/lexer/ bf/parser/ bf/node/ bf/analysis/ result
	rm -f helloWorld.js .d8_history
	rm -f *~

test: bf
	java bf.Main < helloWorld.bf > helloWorld.js
	d8 helloWorld.js
