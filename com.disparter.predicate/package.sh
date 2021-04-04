#!/usr/bin/env bash
mkdir -p mods
jar --create --file=mods/com.disparter.predicate@1.0.jar --module-version=1.0 --main-class=com.disparter.predicate.Main -C bin/com.disparter.predicate .