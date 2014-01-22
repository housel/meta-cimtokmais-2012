HOMEPAGE = "http://www.ros.org/wiki/ros_tutorials"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=13025a19a85b9e9b98b8d7e15e3facbe"

inherit catkin

SRC_URI  = "git://github.com/wg-debs/ros_tutorials-release.git;rev=debian/ros-fuerte-ros-tutorials_0.2.18_lucid;protocol=git"

DEPENDS += "\
	roscpp_core \
	genmsg \
	langs \
	std_msgs \
	ros_comm \
	qt4-qmake \
	libqt4-dev \
	common_msgs \
"

S = "${WORKDIR}"

