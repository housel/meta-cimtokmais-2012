HOMEPAGE = "http://www.ros.org/wiki/catkin"
DESCRIPTION = "Willow Garage low-level build system macros and infrastructure."

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://stack.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

inherit cmake distutils

SRC_URI = "\
	git://github.com/ros/catkin.git;protocol=git \
	file://0002-find_program_required-Suppress-use-of-CMAKE_FIND_ROO.patch \
"

SRCREV = "${PV}"

S = "${WORKDIR}/git"

INC_PR = "r0"

DEPENDS = "\
	python \
	python-argparse \
	python-empy \
	python-nose \
	python-rospkg \
	python-setuptools \
	python-pyyaml \
"
