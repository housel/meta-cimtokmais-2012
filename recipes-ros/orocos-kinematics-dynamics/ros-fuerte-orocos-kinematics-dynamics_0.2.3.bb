SUMMARY = "orocos_kinematics_dynamics"
HOMEPAGE = "http://ros.org/wiki/orocos_kinematics_dynamics"
LICENSE  = "GPL & LGPLv2.1 & BSD & LGPL"
LIC_FILES_CHKSUM = "file://stack.xml;md5=f82b41ee5835e6a11f39f6faf8079091"

STACK = "orocos_kinematics_dynamics"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "git://git.mech.kuleuven.be/robotics/orocos_kinematics_dynamics.git;destsuffix=orocos_kinematics_dynamics;rev=orocos_kinematics_dynamics-0.2.3;protocol=http \
            file://cross-compilation.patch \
"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-common-rosdeps \
	python-sip-native \
	boost \
"

RDEPENDS_${PN} += "\
	ros-fuerte-ros \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/kdl/lib/.debug \
	${ros_stacksdir}/${STACK}/kdl/bin/.debug \
	${ros_stacksdir}/${STACK}/orocos_kdl/lib/.debug \
	${ros_stacksdir}/${STACK}/orocos_kdl/bin/.debug \
	${ros_stacksdir}/${STACK}/python_orocos_kdl/lib/.debug \
	${ros_stacksdir}/${STACK}/python_orocos_kdl/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/kdl/lib/*.a \
	${ros_stacksdir}/${STACK}/orocos_kdl/lib/*.a \
	${ros_stacksdir}/${STACK}/python_orocos_kdl/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/kdl/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/orocos_kdl/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/python_orocos_kdl/build
}

S = "${WORKDIR}/orocos_kinematics_dynamics"

QAPATHTEST[dev-so] = ""
