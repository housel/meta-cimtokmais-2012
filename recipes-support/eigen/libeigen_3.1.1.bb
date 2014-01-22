DESCRIPTION = "A lightweight C++ template library for vector and matrix math"
SECTION = "libs"
LICENSE = "MPL-2.0 & LGPL-3.0 & GPL-3.0 & BSD & Minpack"
LIC_FILES_CHKSUM = "file://COPYING.README;md5=4b1d902a05d1b811b24e1551d8418054"
HOMEPAGE = "http://eigen.tuxfamily.org"
PR = "r0"

SRC_URI = "http://bitbucket.org/eigen/eigen/get/${PV}.tar.bz2"

S = "${WORKDIR}/eigen-eigen-43d9075b23ef"

OECMAKE_SOURCEPATH = "${S}"
OECMAKE_BUILDPATH = "${WORKDIR}/build"
EXTRA_OECMAKE = " -Dpkg_config_libdir=${libdir} "

inherit cmake

SRC_URI[md5sum] = "a045db8c3812188e841d4740362a3792"
SRC_URI[sha256sum] = "531a97c3d96d151c72951e6f295b5e5f3f68f668fd04c9b1a0d84187547121ab"

