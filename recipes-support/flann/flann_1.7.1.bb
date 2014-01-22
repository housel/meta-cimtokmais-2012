DESCRIPTION = "FLANN is a library for performing fast approximate nearest neighbor searches in high dimensional spaces."
HOMEPAGE = "http://www.cs.ubc.ca/~mariusm/index.php/FLANN/FLANN"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=040a44ba915aa6b3b099ea189c7b7e20"

SRC_URI = "http://people.cs.ubc.ca/~mariusm/uploads/FLANN/flann-${PV}-src.zip \
           file://cross-compilation.patch \
"

SRC_URI[md5sum] = "d780795f523eabda7c7ea09c6f5cf235"
SRC_URI[sha256sum] = "eafb8c07cf59ff050be149b15d620ca3dd162e3fce9cb6748cde5d92e0dac775"

BBCLASSEXTEND = "native"

inherit cmake

S = "${WORKDIR}/flann-${PV}-src"

DEPENDS += "\
    python-numpy \
"
