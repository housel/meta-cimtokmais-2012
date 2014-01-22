SUMMARY = "A system to allow node parameters to be changed without restarting the node."
HOMEPAGE = "http://ros.org/wiki/dynamic_reconfigure"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=227bd1fe664d588e63c7b7efd497d0bb"

STACK = "dynamic_reconfigure"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/dynamicreconfig;module=dynamic_reconfigure;rev=dynamic_reconfigure-1.4.2;proto=http \
            file://cross-compilation.patch \
"

DEPENDS += "\
	ros-fuerte-ros-comm-native \
	ros-fuerte-ros-comm \
	ros-fuerte-genmsg-native \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
	ros-fuerte-roscpp-core \
	ros-fuerte-std-msgs \
"

RDEPENDS_${PN} += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/lib/.debug \
	${ros_stacksdir}/${STACK}/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/build
}

S = "${WORKDIR}/dynamic_reconfigure"

