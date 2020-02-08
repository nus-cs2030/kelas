all:
	javac Cruise.java SmallCruise.java BigCruise.java Loader.java
	jshell -q < test1.jsh | sed -f clean.sed > test1.out
	jshell -q < test2.jsh | sed -f clean.sed > test2.out
	jshell -q < test3.jsh | sed -f clean.sed > test3.out
	jshell -q < test4.jsh | sed -f clean.sed > test4.out
	javac Main5.java
	java Main < test5.1.in > test5.1.out
	java Main < test5.2.in > test5.2.out
	java Main < test5.3.in > test5.3.out
	java Main < test5.4.in > test5.4.out
	javac Main6.java
	javac RecycledLoader.java
	java Main < test6.1.in > test6.1.out
	chmod 600 index.html
	m4 index.shtml > index.html
	chmod 400 index.html
	open index.html
