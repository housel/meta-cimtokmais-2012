require connman.inc

SRCREV = "3c0fa84091524c7cd6237744f2088ffee2f1d5ad"
SRC_URI  = "git://git.kernel.org/pub/scm/network/connman/connman.git \
            file://add_xuser_dbus_permission.patch \
            file://connman"
S = "${WORKDIR}/git"
PR = "${INC_PR}.1"
