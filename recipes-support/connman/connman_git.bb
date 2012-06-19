require connman.inc

SRCREV = "c80faf72bfdd1f78562504146f16a3b05874dd92"
SRC_URI  = "git://git.kernel.org/pub/scm/network/connman/connman.git \
            file://add_xuser_dbus_permission.patch \
            file://connman"
S = "${WORKDIR}/git"
PR = "${INC_PR}.0"
