inherit ros-base cmake

EXTRA_OECMAKE = " -DCMAKE_INSTALL_PREFIX:PATH=${ros_prefix} "

# Workaround for -lrt search
cmake_do_generate_toolchain_file_append() {
if [ "X${BUILD_SYS}" = "X${HOST_SYS}" ]; then
    cat >> ${WORKDIR}/toolchain.cmake <<EOF
set( CMAKE_FIND_ROOT_PATH_MODE_LIBRARY BOTH )
EOF
fi
}

catkin_do_generate_toplevel_file() {
	cat > ${WORKDIR}/CMakeLists.txt <<EOF
cmake_minimum_required(VERSION 2.8)
cmake_policy(SET CMP0003 NEW)
cmake_policy(SET CMP0011 NEW)

set(CMAKE_CXX_FLAGS_INIT "-Wall")

set(CMAKE_INSTALL_PREFIX "${ros_prefix}")
set(SETUPTOOLS_DEB_LAYOUT OFF
    CACHE BOOL "ON for debian style python packages layout")
EOF

case ${PN} in
ros-*-catkin|ros-*-catkin-native)
    echo "add_subdirectory(${VCSDIR})" >> ${WORKDIR}/CMakeLists.txt
    ;;
*)
    echo "find_package(catkin)" >> ${WORKDIR}/CMakeLists.txt
    ;;
esac

echo "catkin_workspace()" >> ${WORKDIR}/CMakeLists.txt
}
addtask do_generate_toplevel_file after do_patch before do_configure

EXPORT_FUNCTIONS do_generate_toplevel_file

do_install_prepend() {
        export STAGING_INCDIR=${STAGING_INCDIR}
        export STAGING_LIBDIR=${STAGING_LIBDIR}
        export PYTHONPATH=${D}/usr/lib/${PYTHON_DIR}/site-packages:${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}
        export BUILD_SYS=${BUILD_SYS}
        export HOST_SYS=${HOST_SYS}
}
