HOMEPAGE = "http://www.ros.org/wiki/std_msgs"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=7e800ca6f646448e3c242a8583a9c773"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native nativesdk"

SRC_URI  = "git://github.com/wg-debs/std_msgs-release.git;rev=debian/ros-fuerte-std-msgs_0.4.8_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-genmsg-native \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
"

S = "${WORKDIR}"

