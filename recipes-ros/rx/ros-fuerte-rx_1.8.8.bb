HOMEPAGE = "http://www.ros.org/wiki/rx"
LICENSE  = "BSD,LGPL/BSD,Creative Commons,wxWindows,BSD, Creative Commons"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=d7c21feb183b37c2685fbc4a85fdd79e"

inherit catkin

SRC_URI  = "git://github.com/wg-debs/rx-release.git;rev=debian/ros-fuerte-rx_1.8.8_lucid;protocol=git"

DEPENDS += "\
	ros \
	python-gtk2 \
	graphviz \
	ros_comm \
	python-matplotlib \
	swig-wx \
	wxwidgets \
	wxpython \
	rospack \
"

S = "${WORKDIR}"

