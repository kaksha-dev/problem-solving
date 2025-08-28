#!/usr/bin/bash

# This script runs all tests in the current directory and its subdirectories.
# Usage: ./run_tests.sh

for test_file in $(find tests -type f -name '*.java');
do
    echo "Running test $test_file"
    javac "$test_file" && java -ea "${test_file%.java}"
done