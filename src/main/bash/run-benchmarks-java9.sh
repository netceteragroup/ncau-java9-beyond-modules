#!/bin/bash
$JAVA_HOME/bin/java \
 -XX:+UseParallelGC \
 -Xmx32g -Xms32g -Xmn31g \
 --add-opens java.base/java.io=ALL-UNNAMED \
 -jar target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar java9.txt
