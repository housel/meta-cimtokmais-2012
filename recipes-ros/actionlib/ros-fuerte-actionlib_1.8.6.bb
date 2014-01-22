SUMMARY = "A standardized interface for interfacing with preemptable tasks."
HOMEPAGE = "http://www.ros.org/wiki/actionlib"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=b52ee74310fc1172811835d61ca0ddef"

VCSDIR = "git"
inherit catkin

SRC_URI  = "git://github.com/wg-debs/actionlib-release.git;rev=debian/ros-fuerte-actionlib_1.8.6_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-genmsg-native \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
	ros-fuerte-ros-comm \
	ros-fuerte-common-msgs \
"

S = "${WORKDIR}"

