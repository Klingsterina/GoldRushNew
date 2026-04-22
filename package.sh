#!/usr/bin/env bash
set -e

./mvnw clean package javafx:jlink

echo "Build finished."
echo "Fat jar: target/GoldRush-1.0-SNAPSHOT-jar-with-dependencies.jar"
echo "Runtime image: target/GoldRush"