HOMEPAGE = "http://www.ros.org/wiki/catkin"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://git/stack.xml;md5=a18ba07ab2fd8cdd00511f484f32c44b"
PR = "r1"

VCSDIR = "git"
inherit catkin

BBCLASSEXTEND = "native"

SRC_URI = "git://github.com/housel/catkin.git;rev=1d36b2cfe429cf26f04f1bc2986170534de9a405;protocol=git"

DEPENDS += "\
	cmake \
	gtest \
	python-empy \
	python-nose \
	python-argparse \
	python-setuptools \
	python-rospkg \
	python-pyyaml \
"

S = "${WORKDIR}"

PACKAGES =+ "${PN}-env"

FILES_${PN}-env = "\
    ${ros_prefix}/env.sh \
    ${ros_prefix}/setup.* \
    ${ros_prefix}/etc/catkin/profile.d \
    ${ros_prefix}/.rosinstall \
"
