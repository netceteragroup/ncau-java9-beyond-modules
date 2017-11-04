#!/bin/bash
$JAVA_HOME/bin/java \
 -XX:+UseParallelGC \
 -Xmx32g -Xms32g -Xmn31g \
 --add-opens java.base/java.io=ALL-UNNAMED \
 -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler \
 -jar target/java8comparison-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar graal9.txt
