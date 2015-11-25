SUMMARY = "A Modbus library"
DESCRIPTION = "libmodbus is a C library designed to provide a fast and robust \
implementation of the Modbus protocol. It runs on Linux, Mac OS X, FreeBSD, \
QNX and Windows."
HOMEPAGE = "http://www.libmodbus.org/"
SECTION = "libs"

LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "http://libmodbus.org/site_media/build/${BP}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "dd4262f87ed835c4d1e560f8321a222c"
SRC_URI[sha256sum] = "661e14f9dc904f3f1b034464ddaa5fd4b8472f8f5d1ea10a1148af85591b7ee9"
