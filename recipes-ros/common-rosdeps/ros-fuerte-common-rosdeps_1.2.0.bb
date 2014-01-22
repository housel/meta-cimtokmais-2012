SUMMARY = "common_rosdeps"
HOMEPAGE = "http://ros.org/wiki/common_rosdeps"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=3647db7b247848ff2b91aaab46201748"

STACK = "common_rosdeps"
inherit rosbuild

SRC_URI  = "hg://kforge.ros.org/common;module=rosdepcore;rev=common_rosdeps-1.2.0;proto=https"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-rospack \
"

#	python-gtk2
#	graphviz
#	python-matplotlib
#	swig-wx
#	wxwidgets
#	wxpython

RDEPENDS_${PN} = "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-rospack \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/lib/.debug \
	${ros_stacksdir}/${STACK}/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/./build
}

S = "${WORKDIR}/rosdepcore"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s rosdepcore ${WORKDIR}/${STACK}
}
