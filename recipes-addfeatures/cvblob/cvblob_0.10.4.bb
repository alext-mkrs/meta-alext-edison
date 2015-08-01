SUMMARY = "Blob library for OpenCV"
SECTION = "libs"

LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=6a6a8e020838b23406c81b19c1d46df6"

SRC_URI[md5sum] = "9d5e360c6de6fce36e95f5d64b67b9b1"
SRC_URI[sha256sum] = "94eff3eed03370fac98e9d26a43405a3ac8eb3ca1621157c5738967b95c67bc1"

DEPENDS = "opencv"

SRC_URI = "https://cvblob.googlecode.com/files/${PN}-${PV}-src.tgz"

S = "${WORKDIR}/cvblob"

inherit cmake pkgconfig

