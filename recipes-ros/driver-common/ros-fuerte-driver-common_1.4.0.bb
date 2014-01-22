SUMMARY = "Classes and tools useful to many driver stacks."
HOMEPAGE = "http://ros.org/wiki/driver_common"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=8fc12a9a198cf685581bbfced636ffcd"

STACK = "driver_common"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "svn://code.ros.org/svn/ros-pkg/stacks/driver_common/tags;module=driver_common-1.4.0;rev=;proto=https"

DEPENDS += "\
	ros-fuerte-diagnostics \
	ros-fuerte-ros \
	ros-fuerte-dynamic-reconfigure \
	ros-fuerte-genmsg-native \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
"

RDEPENDS_${PN} += "\
	ros-fuerte-diagnostics \
	ros-fuerte-ros \
	ros-fuerte-dynamic-reconfigure \
	ros-fuerte-genpy \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/driver_base/lib/.debug \
	${ros_stacksdir}/${STACK}/driver_base/bin/.debug \
	${ros_stacksdir}/${STACK}/timestamp_tools/lib/.debug \
	${ros_stacksdir}/${STACK}/timestamp_tools/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/driver_base/lib/*.a \
	${ros_stacksdir}/${STACK}/timestamp_tools/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/driver_base/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/timestamp_tools/build
}

S = "${WORKDIR}/driver_common-1.4.0"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s driver_common-1.4.0 ${WORKDIR}/${STACK}
}
