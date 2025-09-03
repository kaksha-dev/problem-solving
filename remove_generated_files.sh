#!/usr/bin/bash

# This script removes all generated files in the current directory and its subdirectories.
# Generated files include object files, executables, and temporary files.
# Usage: ./remove_generated_files.sh

for file in $(find . -type f -name '*.class');
do
    echo "Removing $file"
    rm -f "$file"
done

