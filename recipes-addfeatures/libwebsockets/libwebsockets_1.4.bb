SUMMARY = "C library for lightweight websocket clients and servers"
DESCRIPTION = "Libwebsockets is a lightweight pure C library built \
               to use minimal CPU and memory resources, and provide \
               fast throughput in both directions."
HOMEPAGE = "http://libwebsockets.org"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=041a1dec49ec8a22e7f101350fd19550"

SRC_URI = "http://git.libwebsockets.org/cgi-bin/cgit/${PN}/snapshot/${PN}-${PV}-chrome43-firefox-36.tar.gz \
           file://remove_cmake_targets.patch \
"

SRC_URI[md5sum] = "0452c278a5cd4349135df2a693f35c28"
SRC_URI[sha256sum] = "e11492477e582ef0b1a6ea2f18d81a9619b449170a3a5c43f32a9468461a9798"

S = "${WORKDIR}/${PN}-${PV}-chrome43-firefox-36"

DEPENDS += "openssl"

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

