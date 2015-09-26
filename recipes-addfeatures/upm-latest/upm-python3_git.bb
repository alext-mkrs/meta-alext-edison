SUMMARY = "Python 3 bindings for sensor/actuator repository for Mraa"
SECTION = "libs"
AUTHOR = "Brendan Le Foll, Tom Ingleby, Yevgeniy Kiveisha"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1cc191275d6a8c5ce039c75b2b3dc29"

DEPENDS = "nodejs swig-native mraa git-native"

SRC_URI = "git://github.com/intel-iot-devkit/upm.git;protocol=https \
           file://specify_python_version.diff \
"
SRCREV = "${AUTOREV}"

PV = "0.4.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit distutils3-base pkgconfig python-dir cmake

# This one is necessary to remove host-specific RPATH
# from adafruitms1438's SWIG Python and JS bindings
EXTRA_OECMAKE_append = " -DCMAKE_SKIP_RPATH=1"

RDEPENDS_${PN} += "upm"
RDEPENDS_${PN}-dbg += "upm-dbg"

PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR}/*"
FILES_${PN}-dbg = "${PYTHON_SITEPACKAGES_DIR}/.debug/"

PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

# In this recipe we aren't interested in anything but Python bindings
do_install () {
  install -d ${D}${PYTHON_SITEPACKAGES_DIR}/
  install -m 644 ${B}/src/*/*pyupm*.so ${D}${PYTHON_SITEPACKAGES_DIR}/
  install -m 644 ${B}/src/*/*pyupm*.py ${D}${PYTHON_SITEPACKAGES_DIR}/
}

