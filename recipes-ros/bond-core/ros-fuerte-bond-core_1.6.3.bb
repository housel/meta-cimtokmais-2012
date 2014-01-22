SUMMARY = "Bond"
HOMEPAGE = "http://ros.org/wiki/bond_core"
LICENSE  = "BSD & MPL-1.1"
LIC_FILES_CHKSUM = "file://stack.xml;md5=982f8e003c954bdc6de5f3f8db724e8a"

STACK = "bond_core"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/common;module=bondcore;rev=bond_core-1.6.3;proto=http"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-genmsg-native \
"

RDEPENDS_${PN} += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/test_bond/lib/.debug \
	${ros_stacksdir}/${STACK}/test_bond/bin/.debug \
	${ros_stacksdir}/${STACK}/smclib/lib/.debug \
	${ros_stacksdir}/${STACK}/smclib/bin/.debug \
	${ros_stacksdir}/${STACK}/bondpy/lib/.debug \
	${ros_stacksdir}/${STACK}/bondpy/bin/.debug \
	${ros_stacksdir}/${STACK}/bondcpp/lib/.debug \
	${ros_stacksdir}/${STACK}/bondcpp/bin/.debug \
	${ros_stacksdir}/${STACK}/bond/lib/.debug \
	${ros_stacksdir}/${STACK}/bond/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/test_bond/lib/*.a \
	${ros_stacksdir}/${STACK}/smclib/lib/*.a \
	${ros_stacksdir}/${STACK}/bondpy/lib/*.a \
	${ros_stacksdir}/${STACK}/bondcpp/lib/*.a \
	${ros_stacksdir}/${STACK}/bond/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/test_bond/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/smclib/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/bondpy/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/bondcpp/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/bond/build
}

S = "${WORKDIR}/bondcore"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s bondcore ${WORKDIR}/${STACK}
}
