#!/usr/bin/env bash
javac -d bin --module-source-path src/main/java $(find src -name "*.java")
