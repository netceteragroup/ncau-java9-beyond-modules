#!/bin/bash
$JAVA_HOME/bin/java \
 -XX:+UseParallelGC \
 -Xmx32g -Xms32g -Xmn31g \
 -jar target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar graal8.txt
