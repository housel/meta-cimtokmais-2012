inherit python-dir

ROSDISTRO = "${@d.getVar('PN', True).split('-')[1]}"

export ros_prefix = "/opt/ros/${ROSDISTRO}"
ros_prefix_virtclass-native = "${STAGING_DIR_NATIVE}/opt/ros/${ROSDISTRO}"

export ros_bindir = "${ros_prefix}/bin"
export ros_libdir = "${ros_prefix}/${baselib}"
export ros_includedir = "${ros_prefix}/include"
export ros_datadir = "${ros_prefix}/share"
export ros_sysconfdir = "${ros_prefix}/etc"
export ros_stacksdir = "${ros_prefix}/stacks"

PREPROCESS_RELOCATE_DIRS += " \
    ${ros_bindir} \
    ${ros_libdir} \
"

PKG_CONFIG_PATH .= ":${PKG_CONFIG_DIR}:${STAGING_DIR_HOST}${ros_libdir}/pkgconfig:${STAGING_DATADIR}/pkgconfig"
PYTHON_SITEPACKAGES_DIR = "${ros_libdir}/${PYTHON_DIR}/site-packages"
export PYTHONPATH = "${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}"
PYTHONPATH_virtclass-native = "${PYTHON_SITEPACKAGES_DIR}"

FILES_${PN} += "${ros_bindir}/* ${ros_libdir}/lib*.so \
                ${PYTHON_SITEPACKAGES_DIR} \
                ${ros_datadir} \
		${ros_sysconfdir} \
                ${ros_stacksdir} \
"

FILES_${PN}-dev += "${ros_includedir} \
                    ${ros_libdir}/pkgconfig \
                    ${ros_datadir}/*/cmake \
                    ${PYTHON_SITEPACKAGES_DIR}/*.la \
"

FILES_${PN}-dbg += "${ros_bindir}/.debug ${ros_libdir}/.debug \
                    ${ros_datadir}/*/bin/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/*/*/.debug \
"

sysroot_stage_dirs_append() {
	from="$1"
	to="$2"

	sysroot_stage_dir $from${ros_includedir} $to${ros_includedir}
	if [ "${BUILD_SYS}" = "${HOST_SYS}" ]; then
		sysroot_stage_dir $from${ros_bindir} $to${ros_bindir}
		sysroot_stage_dir $from${ros_sysconfdir} $to${ros_sysconfdir}
	fi
	if [ -d $from${ros_libdir} ]
	then
		sysroot_stage_libdir $from${ros_libdir} $to${ros_libdir}
	fi
	sysroot_stage_dir $from${ros_datadir} $to${ros_datadir}
        if [ -d $from${ros_stacksdir} ]
	then
		sysroot_stage_dir $from${ros_stacksdir} $to${ros_stacksdir}
        fi
}
