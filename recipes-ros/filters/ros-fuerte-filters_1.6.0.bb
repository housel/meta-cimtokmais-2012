SUMMARY = "filters"
HOMEPAGE = "http://ros.org/wiki/filters"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=3f9dd6f93a1b4ab134c5596be69028b2"

STACK = "filters"
inherit rosbuild

SRC_URI  = "hg://kforge.ros.org/common;module=filters;rev=filters-1.6.0;proto=https"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-pluginlib \
	boost \
"

RDEPENDS_${PN} += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/lib/.debug \
"

S = "${WORKDIR}/${STACK}"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/build
}

