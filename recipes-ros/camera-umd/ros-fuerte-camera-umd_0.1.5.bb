SUMMARY = "Software for USB cameras, stereo, streaming"
HOMEPAGE = "http://ros.org/wiki/camera_umd"
LICENSE  = "GPL & BSD"
LIC_FILES_CHKSUM = "file://stack.xml;md5=16bd2d1e91dc9c3f17c52d65db67aa98"

STACK = "camera_umd"
inherit rosbuild

BBCLASSEXTEND = "native"

SRC_URI  = "git://ram.umd.edu/ros/camera_umd.git;destsuffix=camera_umd;rev=camera_umd-0.1.5;protocol=git \
            file://cross-compilation.patch \
"

DEPENDS += "\
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
	ros-fuerte-rospack \
	ros-fuerte-nodelet-core \
	ros-fuerte-driver-common \
	ros-fuerte-image-common \
"

RDEPENDS_${PN} += "\
	ros-fuerte-common-msgs \
	ros-fuerte-driver-common \
	ros-fuerte-image-common \
	ros-fuerte-nodelet-core \
	ros-fuerte-ros \
	ros-fuerte-ros-comm \
"

FILES_${PN}-dbg += " \
	${ros_stacksdir}/${STACK}/uvc_camera/lib/.debug \
	${ros_stacksdir}/${STACK}/uvc_camera/bin/.debug \
	${ros_stacksdir}/${STACK}/uvc_stereo/lib/.debug \
	${ros_stacksdir}/${STACK}/uvc_stereo/bin/.debug \
	${ros_stacksdir}/${STACK}/jpeg_streamer/lib/.debug \
	${ros_stacksdir}/${STACK}/jpeg_streamer/bin/.debug \
"

FILES_${PN}-staticdev += " \
	${ros_stacksdir}/${STACK}/uvc_camera/lib/*.a \
	${ros_stacksdir}/${STACK}/uvc_stereo/lib/*.a \
	${ros_stacksdir}/${STACK}/jpeg_streamer/lib/*.a \
"

do_install_append() {
    rm -rf ${D}/${ros_stacksdir}/${STACK}/uvc_camera/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/uvc_stereo/build
    rm -rf ${D}/${ros_stacksdir}/${STACK}/jpeg_streamer/build
}

S = "${WORKDIR}/camera_umd"

