#!/bin/bash
$JAVA_HOME/bin/java \
 -XX:+UseParallelGC \
 -jar target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar
