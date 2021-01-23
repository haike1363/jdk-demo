#!/bin/bash
SHELL_DIR=$(cd "$(dirname "${0}")" || exit; pwd)
cd "${SHELL_DIR}" || exit

# -XX:PermSize -XXMaxPermSize设置方法区以及运行时常量池大小
: "${JAVA_OPT:="-XX:PermSize=10M -XX:MaxPermSize=10M"}"
echo JAVA_OPT:"${JAVA_OPT}"

java ${JAVA_OPT} \
-cp ../target/java-test.jar \
pers.haike.demo.gc.PermOOM