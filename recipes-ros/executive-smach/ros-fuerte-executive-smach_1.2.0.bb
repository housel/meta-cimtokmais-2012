SUMMARY = "executive_smach"
HOMEPAGE = "http://ros.org/wiki/executive_smach"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://executive_smach/stack.xml;md5=53f92ff16d88de835ed07d4b02984a49"

inherit catkin

SRC_URI  = "hg://kforge.ros.org/smach;module=executive_smach;rev=executive_smach-1.2.0;proto=http"

DEPENDS += "\
	genmsg \
	langs \
"

RDEPENDS_${PN} = "\
	actionlib \
	ros \
	ros_comm \
	common_msgs \
"

S = "${WORKDIR}"

