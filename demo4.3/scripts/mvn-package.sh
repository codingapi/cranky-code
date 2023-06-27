#!/usr/bin/env bash


cd ../
mvn clean package -DskipTests
cp ./oa/target/*.jar ./scripts/oa.jar
cp ./fs/target/*.jar ./scripts/fs.jar