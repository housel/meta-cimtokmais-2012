DESCRIPTION = "The Visualization Toolkit (VTK) is an open-source, freely available software system for 3D computer graphics, image processing and visualization."
SECTION = "libs"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=486648d48b7ed4d753bfafbf408ec943"
HOMEPAGE = "http://vtk.org"
PR = "r0"

SRC_URI = "http://www.vtk.org/files/release/5.10/vtk-${PV}.tar.gz"

S = "${WORKDIR}/VTK"

inherit cmake

SRC_URI[md5sum] = "a0363f78910f466ba8f1bd5ab5437cb9"
SRC_URI[sha256sum] = "9dd8c750f5d974ca92734d0168db6b534109b9ec30461eb7082a9f71d4716392"
