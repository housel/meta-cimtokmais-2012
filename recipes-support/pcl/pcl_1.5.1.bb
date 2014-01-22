DESCRIPTION = "The Point Cloud Library (or PCL) is a large scale, open project for 2D/3D image and point cloud processing."
SECTION = "libs"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=486648d48b7ed4d753bfafbf408ec943"
HOMEPAGE = "http://pointclouds.org/"
PR = "r0"

SRC_URI = "http://www.pointclouds.org/assets/files/${PV}/PCL-${PV}-Source.tar.bz2"

S = "${WORKDIR}/PCL-${PV}-Source"

inherit cmake

SRC_URI[md5sum] = "d96479ab65245c64d91a6fe1d803275a"
SRC_URI[sha256sum] = "6ab3b0a95e78888ff9779ec841e398f8b96c20eda4a3ce65ee647c1d7cc2b637"

