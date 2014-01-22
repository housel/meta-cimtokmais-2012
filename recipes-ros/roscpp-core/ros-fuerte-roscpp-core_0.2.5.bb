HOMEPAGE = "http://www.ros.org/wiki/roscpp_core"
LICENSE  = "BSD & LGPL"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=1b3a0401b5160a8e5c9420a64c0bed0b"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/roscpp_core-release.git;rev=debian/ros-fuerte-roscpp-core_0.2.5_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-ros \
	boost \
"

S = "${WORKDIR}"

