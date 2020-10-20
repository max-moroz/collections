#!/bin/bash

#==========================================================
# Task 5 - Collection Framework
# This should be at the same folder as CollectionApplication.jar
# This is for executing CollectionApplication application
#==========================================================


# Check for CollectionApplication.jar file
if [ ! -f $(dirname "$0")/CollectionApplication.jar ]; then
echo "Error: CollectionApplication.jar file is not found"
exit 1
fi

# Iterate through the list of given command line arguments
java -jar $(dirname "$0")/CollectionApplication.jar $@
exit 0

