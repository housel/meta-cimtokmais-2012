SUMMARY = "Nodelet core"
HOMEPAGE = "http://ros.org/wiki/nodelet_core"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=76538ca04d96b322e2e26de9b4b8fdb8"

STACK = "nodelet_core"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/common;module=nodeletcore;rev=nodelet_core-1.6.5;proto=http \
            file://cross-compilation.patch \
"

DEPENDS += "\
	ros-fuerte-roscpp-core \
	ros-fuerte-genmsg-native \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
	ros-fuerte-std-msgs \
	ros-fuerte-common-msgs \
	ros-fuerte-ros-comm \
	ros-fuerte-bond-core \
	ros-fuerte-dynamic-reconfigure \
	ros-fuerte-pluginlib \
"

RDEPENDS_${PN} += "\
	ros-fuerte-bond-core \
	ros-fuerte-dynamic-reconfigure \
	ros-fuerte-pluginlib \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-genpy \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/nodelet_topic_tools/lib/.debug \
	${ros_stacksdir}/${STACK}/nodelet_topic_tools/bin/.debug \
	${ros_stacksdir}/${STACK}/nodelet/lib/.debug \
	${ros_stacksdir}/${STACK}/nodelet/bin/.debug \
	${ros_stacksdir}/${STACK}/test_nodelet/lib/.debug \
	${ros_stacksdir}/${STACK}/test_nodelet/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/nodelet_topic_tools/lib/*.a \
	${ros_stacksdir}/${STACK}/nodelet/lib/*.a \
	${ros_stacksdir}/${STACK}/test_nodelet/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/nodelet_topic_tools/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/nodelet/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/test_nodelet/build
}

S = "${WORKDIR}/nodeletcore"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s nodeletcore ${WORKDIR}/${STACK}
}
