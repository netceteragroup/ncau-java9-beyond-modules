#!/bin/bash
# -XX:-CompactStrings \
sudo $JAVA_HOME/bin/java \
 --add-opens java.base/java.lang=ALL-UNNAMED -Djdk.attach.allowAttachSelf \
 -cp target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar \
 com.netcetera.ncau.java9beyondmodules.StringLayout
