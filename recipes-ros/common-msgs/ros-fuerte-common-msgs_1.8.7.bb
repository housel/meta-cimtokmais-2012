SUMMARY = "common messages"
HOMEPAGE = "http://www.ros.org/wiki/common_msgs"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=766d6ca708e3d8757ee41da54430a99f"

VCSDIR = "common"
inherit catkin

SRC_URI  = "git://github.com/wg-debs/common_msgs-release.git;rev=debian/ros-fuerte-common-msgs_1.8.7_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-genmsg-native \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
	ros-fuerte-roscpp-core \
	ros-fuerte-std-msgs \
"

S = "${WORKDIR}"

