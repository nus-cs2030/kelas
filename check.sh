#!/bin/bash

MYFILES="Kelas.class CheckDesign.class Pakej.class"
lab=$1
target=$2

cd $lab
javac ../Kelas.java
mv ../Kelas.class .
javac ../Pakej.java
mv ../Pakej.class .
javac CheckDesign.java

echo "Target directory: $target"
cd $target

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
