#!/bin/bash
sudo $JAVA_HOME/bin/java \
 -XX:+UseSerialGC -Xmx32m \
 -cp target/java8comparison-1.0.0-SNAPSHOT.jar \
 com.netcetera.ncau.java9beyondmodules.StringLayout
