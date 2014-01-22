SUMMARY = "Modeling robot information"
HOMEPAGE = "http://ros.org/wiki/robot_model"
LICENSE  = "BSD & GPL & MIT"
LIC_FILES_CHKSUM = "file://stack.xml;md5=ddfcbf6011ee2fc1efef1d1b15d3f697"

STACK = "robot_model"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "hg://kforge.ros.org/robotmodel;module=robot_model;rev=robot_model-1.8.0;proto=http"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-common-msgs \
	ros-fuerte-geometry \
	curl \
"

RDEPENDS_${PN} += "\
	ros-fuerte-bullet \
	ros-fuerte-geometry \
	ros-fuerte-ros-comm \
	ros-fuerte-orocos-kinematics-dynamics \
	ros-fuerte-common-rosdeps \
	ros-fuerte-ros \
	ros-fuerte-common-msgs \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/urdf_parser/lib/.debug \
	${ros_stacksdir}/${STACK}/urdf_parser/bin/.debug \
	${ros_stacksdir}/${STACK}/urdf_interface/lib/.debug \
	${ros_stacksdir}/${STACK}/urdf_interface/bin/.debug \
	${ros_stacksdir}/${STACK}/ivcon/lib/.debug \
	${ros_stacksdir}/${STACK}/ivcon/bin/.debug \
	${ros_stacksdir}/${STACK}/collada_parser/lib/.debug \
	${ros_stacksdir}/${STACK}/collada_parser/bin/.debug \
	${ros_stacksdir}/${STACK}/robot_state_publisher/lib/.debug \
	${ros_stacksdir}/${STACK}/robot_state_publisher/bin/.debug \
	${ros_stacksdir}/${STACK}/urdf/lib/.debug \
	${ros_stacksdir}/${STACK}/urdf/bin/.debug \
	${ros_stacksdir}/${STACK}/resource_retriever/lib/.debug \
	${ros_stacksdir}/${STACK}/resource_retriever/bin/.debug \
	${ros_stacksdir}/${STACK}/srdf/lib/.debug \
	${ros_stacksdir}/${STACK}/srdf/bin/.debug \
	${ros_stacksdir}/${STACK}/collada_urdf/lib/.debug \
	${ros_stacksdir}/${STACK}/collada_urdf/bin/.debug \
	${ros_stacksdir}/${STACK}/colladadom/lib/.debug \
	${ros_stacksdir}/${STACK}/colladadom/bin/.debug \
	${ros_stacksdir}/${STACK}/simmechanics_to_urdf/lib/.debug \
	${ros_stacksdir}/${STACK}/simmechanics_to_urdf/bin/.debug \
	${ros_stacksdir}/${STACK}/convex_decomposition/lib/.debug \
	${ros_stacksdir}/${STACK}/convex_decomposition/bin/.debug \
	${ros_stacksdir}/${STACK}/kdl_parser/lib/.debug \
	${ros_stacksdir}/${STACK}/kdl_parser/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/urdf_parser/lib/*.a \
	${ros_stacksdir}/${STACK}/urdf_interface/lib/*.a \
	${ros_stacksdir}/${STACK}/ivcon/lib/*.a \
	${ros_stacksdir}/${STACK}/collada_parser/lib/*.a \
	${ros_stacksdir}/${STACK}/robot_state_publisher/lib/*.a \
	${ros_stacksdir}/${STACK}/urdf/lib/*.a \
	${ros_stacksdir}/${STACK}/resource_retriever/lib/*.a \
	${ros_stacksdir}/${STACK}/srdf/lib/*.a \
	${ros_stacksdir}/${STACK}/collada_urdf/lib/*.a \
	${ros_stacksdir}/${STACK}/colladadom/lib/*.a \
	${ros_stacksdir}/${STACK}/simmechanics_to_urdf/lib/*.a \
	${ros_stacksdir}/${STACK}/convex_decomposition/lib/*.a \
	${ros_stacksdir}/${STACK}/kdl_parser/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/urdf_parser/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/urdf_interface/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/ivcon/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/collada_parser/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/robot_state_publisher/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/urdf/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/resource_retriever/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/srdf/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/collada_urdf/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/colladadom/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/simmechanics_to_urdf/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/convex_decomposition/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/kdl_parser/build
}

S = "${WORKDIR}/robot_model"

