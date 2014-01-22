SUMMARY = "Pipeline for processing monocular and stereo images"
HOMEPAGE = "http://ros.org/wiki/image_pipeline"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=e6035feff6741424750840e55c2e723b"

STACK = "image_pipeline"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "svn://code.ros.org/svn/ros-pkg/stacks/image_pipeline/tags;module=image_pipeline-1.8.3;rev=;proto=https"

DEPENDS += "\
	ros-fuerte-common-msgs \
	ros-fuerte-dynamic-reconfigure \
	ros-fuerte-geometry \
	ros-fuerte-image-common \
	ros-fuerte-nodelet-core \
	ros-fuerte-perception-pcl \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-vision-opencv \
"
FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/image_proc/lib/.debug \
	${ros_stacksdir}/${STACK}/image_proc/bin/.debug \
	${ros_stacksdir}/${STACK}/image_view/lib/.debug \
	${ros_stacksdir}/${STACK}/image_view/bin/.debug \
	${ros_stacksdir}/${STACK}/image_rotate/lib/.debug \
	${ros_stacksdir}/${STACK}/image_rotate/bin/.debug \
	${ros_stacksdir}/${STACK}/stereo_image_proc/lib/.debug \
	${ros_stacksdir}/${STACK}/stereo_image_proc/bin/.debug \
	${ros_stacksdir}/${STACK}/depth_image_proc/lib/.debug \
	${ros_stacksdir}/${STACK}/depth_image_proc/bin/.debug \
	${ros_stacksdir}/${STACK}/camera_calibration/lib/.debug \
	${ros_stacksdir}/${STACK}/camera_calibration/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/image_proc/lib/*.a \
	${ros_stacksdir}/${STACK}/image_view/lib/*.a \
	${ros_stacksdir}/${STACK}/image_rotate/lib/*.a \
	${ros_stacksdir}/${STACK}/stereo_image_proc/lib/*.a \
	${ros_stacksdir}/${STACK}/depth_image_proc/lib/*.a \
	${ros_stacksdir}/${STACK}/camera_calibration/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/image_proc/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/image_view/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/image_rotate/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/stereo_image_proc/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/depth_image_proc/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/camera_calibration/build
}

S = "${WORKDIR}/image_pipeline-1.8.3"

do_configure_prepend() {
    rm -f ${WORKDIR}/${STACK} && ln -s image_pipeline-1.8.3 ${WORKDIR}/${STACK}
}
