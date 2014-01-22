SUMMARY = "ROS core"
HOMEPAGE = "http://www.ros.org/wiki/ROS"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=2f42c226cd143722544441b73c2d1d2c"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/ros-release.git;rev=debian/ros-fuerte-ros_1.8.9_lucid;protocol=git \
            file://cross-compilation.patch \
"

DEPENDS += "\
	gtest \
	python-nose-native \
	python \
	python-native \
	bzip2-native \
	python-rospkg-native \
	boost \
	ros-fuerte-rospack \
	pkgconfig-native \
	log4cxx \
"

S = "${WORKDIR}"

