SUMMARY = "C library for lightweight websocket clients and servers"
DESCRIPTION = "Libwebsockets is a lightweight pure C library built \
               to use minimal CPU and memory resources, and provide \
               fast throughput in both directions."
HOMEPAGE = "http://libwebsockets.org"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=041a1dec49ec8a22e7f101350fd19550"

SRC_URI = "https://github.com/warmcat/libwebsockets/archive/v${PV}.tar.gz \
"

SRC_URI[md5sum] = "c66a7437e4d05f1f073630837a2142e9"
SRC_URI[sha256sum] = "a108177ee1d2a3d65dc1b0ae7a6b8801e1302466d8e1bca4952f34418339300d"

DEPENDS += "openssl"
RDEPENDS_${PN} += "zlib"

inherit cmake

do_configure() {
  # This line allows to tell openssl where its config files are located
  #export OPENSSL_CONF=${TMPDIR}/sysroots/x86_64-linux/usr/lib/ssl/openssl.cnf
  export OPENSSL_CONF=${STAGING_LIBDIR}/ssl/openssl.cnf
  cmake_do_configure
}

PACKAGES += "${PN}-tests"

FILES_${PN}-tests += "${bindir}/libwebsockets-test* \
                      ${datadir}/libwebsockets-test-server/* \
                     "

