#!/bin/bash
# get lab parameter
lab=$1

# compile once
javac Kelas.java
javac Pakej.java
javac $lab/CheckDesign.java

mv Kelas.class $lab
mv Pakej.class $lab

# run check for each submission
for f in $lab/*; do
    if [ -d "$f" ]; then
        printf "=============================================\n"
        printf "Running design check on: $(basename $f)\n"
        bash check.sh $lab $f
        printf "=============================================\n\n"
    fi
done

# cleanup compilation
rm $lab/*.class
cd ..
