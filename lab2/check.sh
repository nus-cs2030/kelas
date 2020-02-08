#!/bin/bash

MYFILES="Kelas.class CheckDesign.class Pakej.class"
targetfolder=$1

javac ../Kelas.java
mv ../Kelas.class .
javac ../Pakej.java
mv ../Pakej.class .
javac CheckDesign.java

cd $targetfolder

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
rm *.class
