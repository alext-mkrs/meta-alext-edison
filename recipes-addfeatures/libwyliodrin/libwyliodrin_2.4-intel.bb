DESCRIPTION = "helper library for wyliodrin nodejs server"
HOMEPAGE = "http://github.com/Wyliodrin/libwyliodrin"
LICENSE = "LGPLv2.1"
SECTION = "libs"
DEPENDS = "icu fuse mraa hiredis jansson swig-native libevent"
RDEPENDS_${PN} = "python-redis bash"
PR = "r0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/Wyliodrin/libwyliodrin.git;;protocol=git; "
SRCREV = "b808c9b0ec3ea54058d70c85b63afc02350951fa"

S = "${WORKDIR}/git"

inherit distutils-base pkgconfig python-dir cmake

EXTRA_OECMAKE="-DDEVICEINTEL=ON"
