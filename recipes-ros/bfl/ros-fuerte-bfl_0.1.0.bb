SUMMARY = "bfl"
HOMEPAGE = "http://ros.org/wiki/bfl"
LICENSE  = ",LGPL"
LIC_FILES_CHKSUM = "file://bfl/stack.xml;md5=7edc8b1bdd6a4b4084372f0e627ef418"

inherit catkin

SRC_URI  = "hg://kforge.ros.org/bfl;module=bfl;rev=bfl-0.1.0;proto=http"

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

RDEPENDS_${PN} = "\
	common_rosdeps \
	ros \
"

S = "${WORKDIR}"

