SUMMARY = "pluginlib"
HOMEPAGE = "http://ros.org/wiki/pluginlib"
LICENSE  = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://stack.xml;md5=e7822c8d62203cc708f9c8387cf5dcac"

STACK = "pluginlib"
inherit rosbuild

SRC_URI  = "hg://kforge.ros.org/common;module=pluginlib;rev=pluginlib-1.8.0;proto=http"

DEPENDS += "\
        ros-fuerte-rospack \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	tinyxml \
"

RDEPENDS_${PN} += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
        ${ros_stacksdir}/${STACK}/lib/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/lib/*.a \
"

S = "${WORKDIR}/${STACK}"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/./build
}

