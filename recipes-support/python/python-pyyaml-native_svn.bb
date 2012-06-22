require recipes-devtools/python/python-pyyaml_svn.bb
inherit native
DEPENDS = "libyaml-native python-native python-cython-native"
RDEPENDS_${PN} = ""
PR = "r0"
