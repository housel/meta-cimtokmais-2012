SUMMARY = "ROS communications-related libraries and tools"
HOMEPAGE = "http://www.ros.org/wiki/ros_comm"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=6cf13eae896c056c5d0f496bb2bff467"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI  = "git://github.com/wg-debs/ros_comm-release.git;rev=debian/ros-fuerte-ros-comm_1.8.12_lucid;protocol=git \
            file://cross-compilation.patch \
	    file://boost.patch \
"

DEPENDS += "\
	ros-fuerte-ros \
	log4cxx \
	ros-fuerte-roscpp-core \
	ros-fuerte-gencpp-native \
	ros-fuerte-genpy-native \
	ros-fuerte-genlisp-native \
	apr \
	ros-fuerte-std-msgs \
	python-paramiko \
	boost \
	python-pyyaml \
"

RDEPENDS_${PN} += "\
        python-rospkg \
	ros-fuerte-genpy \
"

S = "${WORKDIR}"

