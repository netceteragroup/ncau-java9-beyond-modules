#!/bin/bash
$JAVA_HOME/bin/java \
 -XX:+UseParallelGC \
 --add-opens java.base/java.io=ALL-UNNAMED \
 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler \
 -jar target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar
