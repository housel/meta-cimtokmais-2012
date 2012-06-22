DESCRIPTION = "nose is nicer testing for python"
SECTION = "devel/python"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://lgpl.txt;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI = "http://pypi.python.org/packages/source/n/nose/nose-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "144f237b615e23f21f6a50b2183aa817"
SRC_URI[archive.sha256sum] = ""

inherit distutils

S = "${WORKDIR}/nose-${PV}"
