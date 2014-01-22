SUMMARY = "Point Cloud Library"
HOMEPAGE = "http://ros.org/wiki/perception_pcl"
LICENSE  = "BSD & LGPL"
LIC_FILES_CHKSUM = "file://stack.xml;md5=0d20e7e5f88ef081fe0c27ab5acf03a2"

STACK = "perception_pcl"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "svn://svn.pointclouds.org/ros/tags;module=perception_pcl_unstable-1.2.2;rev=;proto=http"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-common-msgs \
	ros-fuerte-common-rosdeps \
	ros-fuerte-dynamic-reconfigure \
	ros-fuerte-geometry \
	ros-fuerte-nodelet-core \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

RDEPENDS_${PN} += "\
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/pcl_ros/lib/.debug \
	${ros_stacksdir}/${STACK}/pcl_ros/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/pcl_ros/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/pcl_ros/build
}

S = "${WORKDIR}/perception_pcl_unstable-1.2.2"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s perception_pcl_unstable-1.2.2 ${WORKDIR}/${STACK}
}


cmake_do_generate_toolchain_file_append() {
    cat >> ${WORKDIR}/toolchain.cmake <<EOF
set( PCL_DIR ${STAGING_DIR_HOST}${ros_datadir}/pcl-1.5 )
EOF
}
