HOMEPAGE = "http://www.ros.org/wiki/genmsg"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=e49f2a63f7d77b45ac5e715d855b3b80"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native nativesdk"

SRC_URI  = "git://github.com/wg-debs/genmsg-release.git;rev=debian/ros-fuerte-genmsg_0.3.10_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-catkin-native \
"

S = "${WORKDIR}"

