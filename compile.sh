#!/usr/bin/env bash
javac -d bin --module-source-path src/java/main $(find src -name "*.java")
