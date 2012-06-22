DESCRIPTION = "Library for retrieving information about ROS packages and stacks"
SECTION = "devel/python"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://manifest.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "\
	git://github.com/ros/rospkg.git;protocol=git \
"
SRCREV = "${PV}"

inherit distutils

S = "${WORKDIR}/git"
