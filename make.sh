#!/bin/bash

#==============================================================
# Task 5 - Collection Framework
# Execute from project's root folder
# This is for building project and placing it into newly created directory /dist
# together with all source files and uber-jar
# Java archive is not created if any test failed or code coverage not been met.
#==============================================================

./mvnw clean package

mkdir dist
cp CollectionApplication.cmd CollectionApplication.sh _README.md ./dist
cd target
cp CollectionApplication.jar ../dist
exit 0
