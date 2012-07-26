DESCRIPTION = "Google C++ Testing Framework"
SECTION = "libs"
DEPENDS = ""
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://include/gtest/gtest.h;endline=28;md5=c6443e2c0a211d2ccec9fe856fced5fc"
HOMEPAGE = "http://code.google.com/p/googletest/"
PR = "r0"

SRC_URI = "http://googletest.googlecode.com/files/gtest-${PV}.zip"

SRC_URI[md5sum] = "4577b49f2973c90bf9ba69aa8166b786"
SRC_URI[sha256sum] = "5ec97df8e75b4ee796604e74716d1b50582beba22c5502edd055a7e67a3965d8"

S = "${WORKDIR}/gtest-${PV}"

inherit autotools

BBCLASSEXTEND = "native"

do_install () {
	install -d ${D}${includedir}/gtest/
	install -m 0644 include/gtest/*.h ${D}${includedir}/gtest/
	install -d ${D}${includedir}/gtest/internal/
	install -m 0644 include/gtest/internal/*.h ${D}${includedir}/gtest/internal
}
