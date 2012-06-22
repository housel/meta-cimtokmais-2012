DESCRIPTION = "A powerful and robust templating system for Python"
SECTION = "devel/python"
HOMEPAGE = "http://www.alcyone.com/software/empy/"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

SRC_URI = "http://www.alcyone.com/software/empy/empy-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = ""
SRC_URI[archive.sha256sum] = ""

inherit distutils

S = "${WORKDIR}/empy-${PV}"
