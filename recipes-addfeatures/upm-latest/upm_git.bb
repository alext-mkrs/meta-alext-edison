SUMMARY = "Sensor/Actuator repository for Mraa"
SECTION = "libs"
AUTHOR = "Brendan Le Foll, Tom Ingleby, Yevgeniy Kiveisha"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=e8db6501ed294e65418a933925d12058"

DEPENDS = "nodejs swig-native mraa"

SRC_URI = "git://github.com/intel-iot-devkit/upm.git;protocol=https"
SRCREV = "AUTOINC"

PV = "0.1.8+git${SRCPV}"

S = "${WORKDIR}/git"

inherit distutils-base pkgconfig python-dir cmake

FILES_${PN}-doc += "${datadir}/upm/examples/"
