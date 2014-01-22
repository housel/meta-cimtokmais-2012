SUMMARY = "xacro"
HOMEPAGE = "http://ros.org/wiki/xacro"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://xacro/stack.xml;md5=e96736a4eacb4872c1cacadc45f061b9"

inherit catkin

SRC_URI  = "hg://kforge.ros.org/common;module=xacro;rev=xacro-1.6.1;proto=http"

DEPENDS += "\
"

RDEPENDS_${PN} = "\
	ros \
	ros_comm \
"

S = "${WORKDIR}"

