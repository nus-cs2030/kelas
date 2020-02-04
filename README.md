# `Kelas`

## Simplified Java Reflection for Auto-Assessment of Program Design

### History and Intro
`Kelas` is a wrapper around Java reflection that I wrote (hacked would be more accurate) for PE1 19/20 Sem 1, as a proof-of-concept.  The class aims to automatically checks for design flaws in the students submission.

`Kelas.java` implements the class.

A sample of how the class is used can be found under the `ride` subdirectory, where the file `CheckDesign.java` uses Kelas to check for certain design rules.

There is a bash script `check.sh` that compiles everything and run `CheckDesign` on the sample code, given under the `sample` subdirectory. 

A sample output can be found in `sample.design-bug.txt`
