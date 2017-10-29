#!/bin/bash
# https://github.com/eclipse/openj9/issues/42
# https://www.ibm.com/support/knowledgecenter/en/SSYKE2_8.0.0/com.ibm.java.lnx.80.doc/diag/appendixes/cmdline/xgcpolicy.html
$JAVA_HOME/bin/java \
 -Xgcpolicy:optthruput \
 --add-opens java.base/java.io=ALL-UNNAMED \
 -jar target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar
