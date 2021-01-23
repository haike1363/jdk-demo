#!/bin/bash
SHELL_DIR=$(cd "$(dirname "${0}")" || exit; pwd)
cd "${SHELL_DIR}" || exit

: "${JAVA_OPT:=""}"
echo JAVA_OPT:"${JAVA_OPT}"

# -Xss 栈容量设置，stack size

java ${JAVA_OPT} \
-cp ../target/java-test.jar \
pers.haike.demo.gc.HeapOOM