SUMMARY = "Sensor/Actuator repository for Mraa"
SECTION = "libs"
AUTHOR = "Brendan Le Foll, Tom Ingleby, Yevgeniy Kiveisha"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1cc191275d6a8c5ce039c75b2b3dc29"

DEPENDS = "nodejs swig-native mraa"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/intel-iot-devkit/upm.git;protocol=https \
           file://gpio_enums_rename.patch \
"
SRCREV = "${AUTOREV}"

PV = "0.3.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit distutils-base pkgconfig python-dir cmake

# This one is necessary to remove host-specific RPATH
# from adafruitms1438's SWIG Python and JS bindings
EXTRA_OECMAKE_append = " -DCMAKE_SKIP_RPATH=1"

FILES_${PN}-doc += "${datadir}/upm/examples/"
