DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
AUTHOR = "Phil Thompson"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c43e134c9d8e019b34f3160ebedb924"
PR = "r0"

SRC_URI = "http://riverbankcomputing.co.uk/static/Downloads/sip4/sip-${PV}.tar.gz"

SRC_URI[md5sum] = "76192829cc42ec558db46e4f9e1d8ba9"
SRC_URI[sha256sum] = "ec295f71ef339c5b98db5650865f2c6c1200c4085b7a3f33f284111e1f534ac1"

S = "${WORKDIR}/sip-${PV}"

inherit qmake_base native python-dir

EXTRA_QMAKEVARS_POST += "CONFIG=console"

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

do_configure() {
    python configure.py
}

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}
