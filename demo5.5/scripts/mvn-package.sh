#!/usr/bin/env bash


cd ../
mvn clean package -DskipTests
cp ./server/target/*.jar ./scripts/server.jar
