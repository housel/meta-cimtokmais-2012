SUMMARY = "geometry and math libraries"
HOMEPAGE = "http://ros.org/wiki/bullet"
LICENSE  = "BSD & LGPL & ZLib"
LIC_FILES_CHKSUM = "file://stack.xml;md5=9509876dc60e8e6b266626702e300714"

STACK = "bullet"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/geometry;module=bullet;rev=bullet-2.79;proto=https"

DEPENDS += "\
	ros-fuerte-common-rosdeps \
	ros-fuerte-ros \
"

RDEPENDS_${PN} = "\
	ros-fuerte-common-rosdeps \
	ros-fuerte-ros \
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

S = "${WORKDIR}/bullet"

