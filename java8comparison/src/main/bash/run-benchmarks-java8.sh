#!/bin/bash
$JAVA_HOME/bin/java \
 -XX:+UseParallelGC \
 -Xmx32g -Xms32g -Xmn31g \
 -jar target/java8comparison-1.0.0-SNAPSHOT.jar java8.txt
