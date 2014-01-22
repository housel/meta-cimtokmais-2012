SUMMARY = "Robot diagnostics and instrumentation tools."
HOMEPAGE = "http://ros.org/wiki/diagnostics"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=4ec0e661785731383b79d47a88413e6e"

STACK = "diagnostics"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "svn://code.ros.org/svn/ros-pkg/stacks/diagnostics/tags;module=diagnostics-1.6.4;rev=;proto=https \
            file://diagnostics-build.patch \
"

DEPENDS += "\
	ros-fuerte-common-msgs \
	ros-fuerte-pluginlib \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-common-msgs \
	tinyxml \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/test_diagnostic_aggregator/lib/.debug \
	${ros_stacksdir}/${STACK}/test_diagnostic_aggregator/bin/.debug \
	${ros_stacksdir}/${STACK}/self_test/lib/.debug \
	${ros_stacksdir}/${STACK}/self_test/bin/.debug \
	${ros_stacksdir}/${STACK}/diagnostic_analysis/lib/.debug \
	${ros_stacksdir}/${STACK}/diagnostic_analysis/bin/.debug \
	${ros_stacksdir}/${STACK}/diagnostic_aggregator/lib/.debug \
	${ros_stacksdir}/${STACK}/diagnostic_aggregator/bin/.debug \
	${ros_stacksdir}/${STACK}/diagnostic_updater/lib/.debug \
	${ros_stacksdir}/${STACK}/diagnostic_updater/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/test_diagnostic_aggregator/lib/*.a \
	${ros_stacksdir}/${STACK}/self_test/lib/*.a \
	${ros_stacksdir}/${STACK}/diagnostic_analysis/lib/*.a \
	${ros_stacksdir}/${STACK}/diagnostic_aggregator/lib/*.a \
	${ros_stacksdir}/${STACK}/diagnostic_updater/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/test_diagnostic_aggregator/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/self_test/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/diagnostic_analysis/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/diagnostic_aggregator/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/diagnostic_updater/build
}

S = "${WORKDIR}/diagnostics-1.6.4"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK}; ln -s diagnostics-1.6.4 ${WORKDIR}/${STACK}
}
