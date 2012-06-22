require catkin.inc
inherit native

PR = "${INC_PR}.1"

BBCLASSEXTEND = "nativesdk"

cmake_do_generate_toolchain_file_append() {
	cat >> ${WORKDIR}/toolchain.cmake <<EOF
set( CMAKE_FIND_ROOT_PATH_MODE_LIBRARY BOTH )
EOF
}
