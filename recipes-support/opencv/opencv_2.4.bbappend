FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://opencv-2.4.0-fix-pkgconfig.patch"
