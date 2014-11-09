DESCRIPTION = "Small command line utility for grabbing JPEGs form V4L2 devices (e.g. USB webcams)"
HOMEPAGE = "http://www.twam.info/linux/v4l2grab-grabbing-jpegs-from-v4l2-devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1a689deca649cde4b83b2327802f9d68"

# As long as master branch is now beyond the latest tag, let's just use the date
PV = "20141109"
PR = "r0"

DEPENDS = "jpeg"

SRC_URI = "git://github.com/twam/v4l2grab.git;protocol=https;branch=master"
# This is the latest commit as of 09 Nov 2014
SRCREV = "bb4358911b9581dcf8937962c1355a1c225a2bd7"

S = "${WORKDIR}/git"

inherit autotools gettext

PACKAGES = "${PN} ${PN}-dbg"

