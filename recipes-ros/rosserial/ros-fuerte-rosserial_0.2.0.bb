SUMMARY = "ROS Serial Client Library"
HOMEPAGE = "http://ros.org/wiki/rosserial"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=cb0b4c3530a003bdf4bfb9f747cc5526"

STACK = "rosserial"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/rosserial;module=hg;rev=rosserial-0.2.0;proto=https"

DEPENDS += "\
	gtest \
	python-nose \
	python \
	bzip2 \
	python-rospkg \
	boost \
	ros-fuerte-rospack \
	pkgconfig-native \
	ros-fuerte-common-msgs \
	ros-fuerte-geometry \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

RDEPENDS_${PN} += "\
	ros-fuerte-common-msgs \
	ros-fuerte-geometry \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	python-serial \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/rosserial_python/lib/.debug \
	${ros_stacksdir}/${STACK}/rosserial_python/bin/.debug \
	${ros_stacksdir}/${STACK}/rosserial_msgs/lib/.debug \
	${ros_stacksdir}/${STACK}/rosserial_msgs/bin/.debug \
	${ros_stacksdir}/${STACK}/rosserial_arduino/lib/.debug \
	${ros_stacksdir}/${STACK}/rosserial_arduino/bin/.debug \
	${ros_stacksdir}/${STACK}/rosserial_client/lib/.debug \
	${ros_stacksdir}/${STACK}/rosserial_client/bin/.debug \
	${ros_stacksdir}/${STACK}/rosserial_xbee/lib/.debug \
	${ros_stacksdir}/${STACK}/rosserial_xbee/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/rosserial_python/lib/*.a \
	${ros_stacksdir}/${STACK}/rosserial_msgs/lib/*.a \
	${ros_stacksdir}/${STACK}/rosserial_arduino/lib/*.a \
	${ros_stacksdir}/${STACK}/rosserial_client/lib/*.a \
	${ros_stacksdir}/${STACK}/rosserial_xbee/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/rosserial_python/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/rosserial_msgs/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/rosserial_arduino/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/rosserial_client/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/rosserial_xbee/build
}

S = "${WORKDIR}/hg"

EXTRA_OEROSBUILD = "--skip-blacklist"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s hg ${WORKDIR}/${STACK}
    touch ${S}/rosserial_arduino/ROS_BUILD_BLACKLIST
    touch ${S}/rosserial_client/ROS_BUILD_BLACKLIST
    touch ${S}/rosserial_xbee/ROS_BUILD_BLACKLIST
}
