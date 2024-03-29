DESCRIPTION = "A YAML parser and emitter for C++"
SECTION = "libs"
DEPENDS = ""
LICENSE = "MIT"
HOMEPAGE = "http://code.google.com/p/yaml-cpp/"
PR = "r0"

SRC_URI = "http://yaml-cpp.googlecode.com/files/yaml-cpp-${PV}.tar.gz"

LIC_FILES_CHKSUM = "file://license.txt;md5=7c6a629da965ebdfba9f6fdb76ab8ab4"

EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

#build this:
S = "${WORKDIR}/yaml-cpp"

BBCLASSEXTEND = "native"

inherit cmake

SRC_URI[md5sum] = "9aa519205a543f9372bf4179071c8ac6"
SRC_URI[sha256sum] = "2cd038b5a1583b6745e949e196fba525f6d0d5fd340566585fde24fc7e117b82"
