DESCRIPTION = "TinyXml is a simple and small C++ XML parser that can be easily integrated into other programs"
SECTION = "libs"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://tinystr.h;beginline=4;endline=21;md5=135624eef03e1f1101b9ba9ac9b5fffd"
HOMEPAGE = "http://www.grinninglizard.com/tinyxml"
PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/project/tinyxml/tinyxml/2.6.2/tinyxml_2_6_2.zip \
	   file://enforce-use-stl.patch \
"

SRC_URI[md5sum] = "2a0aaf609c9e670ec9748cd01ed52dae"
SRC_URI[sha256sum] = "ac6bb9501c6f50cc922d22f26b02fab168db47521be5e845b83d3451a3e1d512"

S = "${WORKDIR}/tinyxml"

LD = "${CXX}"

do_compile() {
  rm -f tinyxml.o tinyxmlparser.o tinyxmlerror.o
  oe_runmake TINYXML_USE_STL=YES tinyxml.o tinyxmlparser.o tinyxmlerror.o
  ${AR} cr libtinyxml.a tinyxml.o tinyxmlparser.o tinyxmlerror.o
  rm -f tinyxml.o tinyxmlparser.o tinyxmlerror.o
  oe_runmake TINYXML_USE_STL=YES CXXFLAGS="${CXXFLAGS} -fPIC" tinyxml.o tinyxmlparser.o tinyxmlerror.o
  ${CXX} -shared -Wl,-soname,libtinyxml.so.${PV} -o libtinyxml.so.${PV} ${LDFLAGS} tinyxml.o tinyxmlparser.o tinyxmlerror.o
}

do_install() {
  install -d ${D}${includedir}
  install -m 0644 tinyxml.h tinystr.h ${D}${includedir}
  install -d ${D}${libdir}
  install -m 0644 libtinyxml.* ${D}${libdir}
  ln -sf libtinyxml.so.${PV} ${D}${libdir}/libtinyxml.so
}
