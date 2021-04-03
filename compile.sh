#!/usr/bin/env bash
javac -d bin --module-source-path src $(find src -name "*.java")
