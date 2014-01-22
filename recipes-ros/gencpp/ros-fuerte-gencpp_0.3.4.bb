HOMEPAGE = "http://www.ros.org/wiki/roscpp"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=9aa81ebdd46a5405327aa347ccfe78ab"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/gencpp-release.git;rev=debian/ros-fuerte-gencpp_0.3.4_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-genmsg \
"

S = "${WORKDIR}"
