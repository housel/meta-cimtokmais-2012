HOMEPAGE = "http://www.ros.org/wiki/rospack"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=29abc8cd1b85046c722444651f76c37e"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/rospack-release.git;rev=debian/ros-fuerte-rospack_2.0.13_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-catkin-native \
	gtest \
	boost \
"

S = "${WORKDIR}"

