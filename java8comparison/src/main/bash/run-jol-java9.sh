#!/bin/bash
# -XX:-CompactStrings \
sudo $JAVA_HOME/bin/java \
 -XX:+UseSerialGC -Xmx32m \
 --add-opens java.base/java.lang=ALL-UNNAMED -Djdk.attach.allowAttachSelf \
 -cp target/java8comparison-1.0.0-SNAPSHOT.jar \
 com.netcetera.ncau.java9beyondmodules.StringLayout
