inherit cmake ros-base

ROSDISTRO := "${@d.getVar('PN', True).split('-')[1]}"

DEPENDS += "\
    ros-${ROSDISTRO}-ros \
    ros-${ROSDISTRO}-ros-native \
"

export ROS_ROOT = "${WORKDIR}/ros"
export ROS_PACKAGE_PATH = "${WORKDIR}:${STAGING_DIR_HOST}${ros_datadir}:${STAGING_DIR_HOST}${ros_stacksdir}:${STAGING_DIR_NATIVE}${ros_datadir}:${STAGING_DIR_NATIVE}${ros_stacksdir}"
export PATH .= ":${STAGING_DIR_NATIVE}${ros_bindir}"

PATCHTOOL = "git"

cmake_do_generate_toolchain_file_append() {
    cat >> ${WORKDIR}/toolchain.cmake <<EOF
set( rosbuild_test_nobuild TRUE )
set(_gtest_CFLAGS_OTHER "-pthread")
EOF
}

do_configure() {
    cp -r ${STAGING_DIR_NATIVE}${ros_datadir}/ros ${WORKDIR}
    ln -sf ${WORKDIR}/toolchain.cmake ${ROS_ROOT}/rostoolchain.cmake
}

do_compile() {
    export PYTHONPATH=${D}/usr/lib/${PYTHON_DIR}/site-packages:${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}
    python -mcompileall . || true
    rosmake -V    --disable-logging ${EXTRA_OEROSBUILD} ${STACK}
    rosmake -V -i --disable-logging ${EXTRA_OEROSBUILD} ${STACK}
}

do_install() {
    mkdir -p ${D}/${ros_stacksdir}/${STACK}
    tar -c --exclude ".svn*" --exclude ".git*" --exclude ".hg*" -f - . \
        | tar -C ${D}/${ros_stacksdir}/${STACK} -xf -
    ${PYTHON} ${ROSCOEBASE}/scripts/fixrpath.py ${D}/${ros_stacksdir}/${STACK} \
        ${S} ${ros_stacksdir}/${STACK} \
        ${STAGING_DIR_HOST}/ /
}
