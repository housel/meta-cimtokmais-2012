DESCRIPTION = "paramiko is a module for python that implements the SSH2 protocol for secure (encrypted and authenticated) connections to remote machines"
SECTION = "devel/python"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7fbc338309ac38fefcd64b04bb903e34"

SRC_URI = "http://www.lag.net/paramiko/download/paramiko-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "ce8e2c254378312a264206f65c354d72"
SRC_URI[archive.sha256sum] = ""

BBCLASSEXTEND = "native"

inherit setuptools

S = "${WORKDIR}/paramiko-${PV}"
