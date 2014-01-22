SUMMARY = "common code for personal robots"
HOMEPAGE = "http://ros.org/wiki/common"
LICENSE  = "BSD,LGPL,MIT,ZLib,Boost Software License"
LIC_FILES_CHKSUM = "file://common/stack.xml;md5=1ee75584b40d4e5b316db55894bdae36"

VCSDIR = "common"
inherit catkin

SRC_URI  = "hg://kforge.ros.org/common;module=common;rev=common-1.8.0;proto=http"

DEPENDS += "\
"

RDEPENDS_${PN} += "\
	actionlib \
	ros \
	ros_comm \
	pluginlib \
"

S = "${WORKDIR}"

