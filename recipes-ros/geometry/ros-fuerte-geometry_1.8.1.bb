SUMMARY = "geometry and math libraries"
HOMEPAGE = "http://ros.org/wiki/geometry"
LICENSE  = "BSD & LGPL & ZLib"
LIC_FILES_CHKSUM = "file://stack.xml;md5=f33d824aafbfc2e809cbcbdcfca051c9"

STACK = "geometry"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/geometry;module=geometry;rev=geometry-1.8.1;proto=http \
            file://boost-libraries.patch \
"

DEPENDS += "\
	ros-fuerte-bullet \
	ros-fuerte-ros-comm \
	ros-fuerte-orocos-kinematics-dynamics \
	ros-fuerte-common-rosdeps \
	ros-fuerte-ros \
	ros-fuerte-common-msgs \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/tf/lib/.debug \
	${ros_stacksdir}/${STACK}/tf/bin/.debug \
	${ros_stacksdir}/${STACK}/angles/lib/.debug \
	${ros_stacksdir}/${STACK}/angles/bin/.debug \
	${ros_stacksdir}/${STACK}/tf_conversions/lib/.debug \
	${ros_stacksdir}/${STACK}/tf_conversions/bin/.debug \
	${ros_stacksdir}/${STACK}/eigen_conversions/lib/.debug \
	${ros_stacksdir}/${STACK}/eigen_conversions/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/tf/lib/*.a \
	${ros_stacksdir}/${STACK}/angles/lib/*.a \
	${ros_stacksdir}/${STACK}/tf_conversions/lib/*.a \
	${ros_stacksdir}/${STACK}/eigen_conversions/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/tf/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/angles/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/tf_conversions/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/eigen_conversions/build
}

S = "${WORKDIR}/geometry"


