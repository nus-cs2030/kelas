#!/bin/bash

# get lab parameter
lab=$1

# Compile src files
javac src/*.java -d $lab

# Compile CheckDesign.java file
javac $lab/CheckDesign.java -d $lab

# run check for each submission
for f in $lab/*; do
    if [ -d "$f" ]; then
        printf "=============================================\n"
        printf "Running design check on: $(basename $f)\n"
        bash check.sh $lab $f
        printf "=============================================\n\n"
    fi
done

# cleanup class files
rm $lab/*.class
