SUMMARY = "Common code for working with images"
HOMEPAGE = "http://ros.org/wiki/image_common"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=3cf39f6714eaaa9155854938565e9f1e"

STACK = "image_common"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "svn://code.ros.org/svn/ros-pkg/stacks/image_common/tags;module=image_common-1.8.0;rev=;proto=https"

DEPENDS += "\
	ros-fuerte-common-msgs \
	ros-fuerte-common-rosdeps \
	ros-fuerte-pluginlib \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	yaml-cpp \
	gtest \
	boost \
"

RDEPENDS_${PN} += "\
	ros-fuerte-common-msgs \
	ros-fuerte-common-rosdeps \
	ros-fuerte-pluginlib \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/camera_info_manager/lib/.debug \
	${ros_stacksdir}/${STACK}/camera_info_manager/bin/.debug \
	${ros_stacksdir}/${STACK}/image_transport/lib/.debug \
	${ros_stacksdir}/${STACK}/image_transport/bin/.debug \
	${ros_stacksdir}/${STACK}/polled_camera/lib/.debug \
	${ros_stacksdir}/${STACK}/polled_camera/bin/.debug \
	${ros_stacksdir}/${STACK}/camera_calibration_parsers/lib/.debug \
	${ros_stacksdir}/${STACK}/camera_calibration_parsers/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/camera_info_manager/lib/*.a \
	${ros_stacksdir}/${STACK}/image_transport/lib/*.a \
	${ros_stacksdir}/${STACK}/polled_camera/lib/*.a \
	${ros_stacksdir}/${STACK}/camera_calibration_parsers/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/camera_info_manager/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/image_transport/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/polled_camera/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/camera_calibration_parsers/build
}

S = "${WORKDIR}/image_common-1.8.0"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s image_common-1.8.0 ${WORKDIR}/${STACK}
}
