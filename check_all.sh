#!/bin/bash
# get lab parameter
lab=$1

# compile once
javac Kelas.java
mv Kelas.class $lab
javac Pakej.java
mv Pakej.class $lab
javac $lab/CheckDesign.java

# run check for each submission
for f in $lab/*; do
    if [ -d "$f" ]; then
        bash check.sh $lab $(basename $f)
    fi
done

# cleanup compilation
rm *.class
cd $lab
rm *.class