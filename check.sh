#!/bin/bash

# Required files for autograding
REQUIRED="Check Kelas KelasFields KelasMethods KelasUtils CheckDesign"

# Lab folder path
lab=$1

# Submission/student id
target=$2

# cd into student submission folder
cd $target

# Symlink all compiled class files into directory
for i in $REQUIRED
do
	if [ -e ${i}.class ]
	then
		rm ${i}.class
	fi
	ln -s ../$i.class .
done

# Compile all files
javac *.java

# Run CheckDesign
java CheckDesign | tee $userid.design-bug.txt

# Remove all symlinks
rm *.class

# Go back up one level
cd ..
