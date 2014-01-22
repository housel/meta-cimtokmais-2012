require ros-fuerte-rospack_${PV}.bb
inherit native

OECMAKE_RPATH = "${ros_libdir}"
OECMAKE_RPATH_virtclass-native = "${ros_libdir}"
