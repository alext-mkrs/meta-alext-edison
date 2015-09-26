SUMMARY = "Python 3 bindings for mraa - low level skeleton library for communication on Intel platforms"
SECTION = "libs"
AUTHOR = "Brendan Le Foll, Tom Ingleby"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=e8db6501ed294e65418a933925d12058"

# git is required to get a good version from git describe
DEPENDS = "nodejs swig-native"

SRC_URI = "git://github.com/intel-iot-devkit/mraa.git;protocol=https \
"

SRCREV = "${AUTOREV}"
PV = "0.8.0+git${SRCPV}"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "mraa"
RDEPENDS_${PN}-dbg += "mraa-dbg"

inherit distutils3-base pkgconfig python-dir cmake

PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR}/*"
FILES_${PN}-dbg = "${PYTHON_SITEPACKAGES_DIR}/.debug/"

EXTRA_OECMAKE_append = " -DBUILDPYTHON3=ON"
PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

do_compile_prepend () {
  # when yocto builds in ${D} it does not have access to ../git/.git so git
  # describe --tags fails. In order not to tag our version as dirty we use this
  # trick
  sed -i 's/-dirty//' src/version.c
}

# In this recipe we aren't interested in anything but Python bindings
do_install () {
  install -d ${D}${PYTHON_SITEPACKAGES_DIR}/
  install -m 644 ${B}/src/python/_mraa.so ${D}${PYTHON_SITEPACKAGES_DIR}/
  install -m 644 ${B}/src/python/mraa.py ${D}${PYTHON_SITEPACKAGES_DIR}/
}
