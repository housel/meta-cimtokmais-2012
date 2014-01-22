HOMEPAGE = "http://www.ros.org/wiki/genpy"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=0e3ca9a965afbf02fe6fcc939cb824a7"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/genpy-release.git;rev=debian/ros-fuerte-genpy_0.3.7_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-genmsg-native \
"

RDEPENDS_${PN} += "\
	ros-fuerte-genmsg \
"

S = "${WORKDIR}"

