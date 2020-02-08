# `Kelas`

## Simplified Java Reflection for Auto-Assessment of Program Design

### Usage
`bash check_all.sh <folder-name ie "lab2">`

Script will check design for all folders within the lab folder specified. Each folder represents one submission.

### Project Structure
- `Kelas.java`: Class wrapper
- `Pakej.java`: Helper methods
- :file_folder: *lab*
  - `CheckDesign.java` - Define lab checks
  - :file_folder: *Submission1*
  - :file_folder: *Submission2*

### Todo
 More restructuring and code organization to be done (methods are a bit messy at the moment).
- Cut down `Kelas` methods to essentials
- Combinations of checks should be done in `Pakej`
- Rename long method names

### History and Intro
`Kelas` is a wrapper around Java reflection that I wrote (hacked would be more accurate) for PE1 19/20 Sem 1, as a proof-of-concept.  The project aims to automatically checks for design flaws in the students submission.
