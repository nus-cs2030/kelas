#!/bin/bash
MYFILES="Kelas.class CheckDesign.class Pakej.class"
javac ../Kelas.java

javac ../Pakej.java
mv ../Kelas.class .
mv ../Pakej.class .
javac CheckDesign.java


cd sample
javac *.java
for i in $MYFILES
do
	if [ -e $i ]
	then
		rm $i
	fi
	ln -s ../$i .
done
java CheckDesign | tee $userid.design-bug.txt
rm *.class
cd ..
