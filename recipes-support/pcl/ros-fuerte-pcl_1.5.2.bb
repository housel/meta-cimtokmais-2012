DESCRIPTION = "The Point Cloud Library (or PCL) is a large scale, open project for 2D/3D image and point cloud processing."
SECTION = "libs"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=486648d48b7ed4d753bfafbf408ec943"
HOMEPAGE = "http://pointclouds.org/"
PR = "r0"

SRC_URI = "git://github.com/wg-debs/pcl.git;rev=${PV};proto=git \
           file://cross-compilation.patch \
"

S = "${WORKDIR}/git"

inherit ros-base cmake

EXTRA_OECMAKE += " \
    -DUSE_ROS=ON \
    -DROS_DIR=${STAGING_DIR_NATIVE}${ros_datadir}/ros/cmake \
    -DCMAKE_INSTALL_PREFIX:PATH=${ros_prefix} \
"

DEPENDS += "\
    ros-fuerte-catkin-native \
    ros-fuerte-roscpp-core \
    ros-fuerte-std-msgs \
    ros-fuerte-common-msgs \
    libeigen \
    flann \
"

do_generate_toolchain_file_append() {
if [ "X${BUILD_SYS}" = "X${HOST_SYS}" ]; then
    cat >> ${WORKDIR}/toolchain.cmake <<EOF
set( CMAKE_SKIP_RPATH TRUE )
EOF
fi
}

FILES_${PN}-dev = "${ros_includedir} \
                   ${ros_libdir}/lib*${SOLIBSDEV} \
                   ${ros_libdir}/*.la \
		   ${ros_datadir}/pcl-1.5 \
"
FILES_${PN} = "${ros_bindir}/* ${ros_libdir}/lib*${SOLIBS} \
               ${ros_datadir}/pcl \
"

