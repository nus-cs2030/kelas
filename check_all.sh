#!/bin/bash

lab=$1

for f in $lab/*; do
    if [ -d "$f" ]; then
        bash check.sh $lab $(basename $f)
    fi
done
