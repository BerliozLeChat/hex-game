all : prepare doc

.PHONY : prepare
prepare :
	-mkdir bin
	javac src/hexgame/* -d bin

.PHONY : doc
doc :
	-mkdir ./doc/javadoc
	javadoc -private -splitindex -author -version -charset UTF-8 -d ./doc/javadoc hexgame -sourcepath ./src

.PHONY : run
run :
	javac src/Main.java -d bin/ -cp bin/
	cd bin && java Main

.PHONY : clean
clean :
	-rm -rf bin
	-rm -rf doc/javadoc
