SUMMARY = "opencv"
HOMEPAGE = "http://ros.org/wiki/vision_opencv"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=7c8de6dc70c56bd1687d2deabef590d5"

STACK = "vision_opencv"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "svn://code.ros.org/svn/ros-pkg/stacks/vision_opencv/tags;module=vision_opencv-1.8.3;rev=;proto=https"

DEPENDS += "\
	opencv \
	ros-fuerte-common-msgs \
	ros-fuerte-geometry \
	ros-fuerte-orocos-kinematics-dynamics \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

RDEPENDS_${PN} += "\
	ros-fuerte-common-msgs \
	ros-fuerte-geometry \
	ros-fuerte-orocos-kinematics-dynamics \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/opencv2/lib/.debug \
	${ros_stacksdir}/${STACK}/opencv2/bin/.debug \
	${ros_stacksdir}/${STACK}/opencv_tests/lib/.debug \
	${ros_stacksdir}/${STACK}/opencv_tests/bin/.debug \
	${ros_stacksdir}/${STACK}/image_geometry/lib/.debug \
	${ros_stacksdir}/${STACK}/image_geometry/bin/.debug \
	${ros_stacksdir}/${STACK}/cv_markers/lib/.debug \
	${ros_stacksdir}/${STACK}/cv_markers/bin/.debug \
	${ros_stacksdir}/${STACK}/cv_bridge/lib/.debug \
	${ros_stacksdir}/${STACK}/cv_bridge/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/opencv2/lib/*.a \
	${ros_stacksdir}/${STACK}/opencv_tests/lib/*.a \
	${ros_stacksdir}/${STACK}/image_geometry/lib/*.a \
	${ros_stacksdir}/${STACK}/cv_markers/lib/*.a \
	${ros_stacksdir}/${STACK}/cv_bridge/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/opencv2/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/opencv_tests/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/image_geometry/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/cv_markers/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/cv_bridge/build
}

S = "${WORKDIR}/vision_opencv-1.8.3"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s vision_opencv-1.8.3 ${WORKDIR}/${STACK}
}
