DESCRIPTION = "AVR Downloader/UploaDEr"
HOMEPAGE = "http://www.nongnu.org/avrdude/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

S = "${WORKDIR}/avrdude"
SRC_URI = "svn://svn.sv.gnu.org/avrdude/trunk;module=avrdude;protocol=svn"
SRCREV = "974"

DEPENDS = "libusb"

inherit autotools
