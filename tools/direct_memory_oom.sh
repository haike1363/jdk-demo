#!/bin/bash
SHELL_DIR=$(cd "$(dirname "${0}")" || exit; pwd)
cd "${SHELL_DIR}" || exit

# -XX:MaxDirectMemorySize，默认与-Xmx一样
: "${JAVA_OPT:="-XX:MaxDirectMemorySize=10M"}"
echo JAVA_OPT:"${JAVA_OPT}"

java ${JAVA_OPT} \
-cp ../target/java-test.jar \
pers.haike.demo.gc.DirectMemoryOOM