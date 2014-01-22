HOMEPAGE = "http://www.ros.org/wiki/roslisp"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=ba636343ca7667ddc97eaa4ab863e0ba"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/genlisp-release.git;rev=debian/ros-fuerte-genlisp_0.3.3_lucid;protocol=git"

DEPENDS += "\
	ros-fuerte-genmsg \
"

S = "${WORKDIR}"

