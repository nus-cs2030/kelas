# Kelas

## Simplified Java Reflection for Auto-Assessment of Program Design

### Usage
`bash check_all.sh <folder-name ie "lab2">`

Script will check design for all folders within the lab folder specified. Each folder represents one submission.
If you stop the script halfway, make sure to delete all class files before running the script again, or the symbolic links will fail.

### Project Structure
- `Kelas` 
    - Class wrapper
- `KelasFields / KelasMethods`
    - Expresses fields/methods of class
    - Methods can be chained
    - End with terminal operations
- `KelasUtils` 
    - Utility methods
- `check_all / check.sh`
    - Bash script to run
- :open_file_folder: *lab*
  - `CheckDesign.java` - Define lab checks
  - :file_folder: *Submission1*
  - :file_folder: *Submission2*

### History and Intro
`Kelas` is a wrapper around Java reflection that I wrote (hacked would be more accurate) for PE1 19/20 Sem 1, as a proof-of-concept.  The project aims to automatically checks for design flaws in the students submission.
