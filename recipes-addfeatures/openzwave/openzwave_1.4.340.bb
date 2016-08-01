DESCRIPTION = "free software library that interfaces with selected Z-Wave PC controllers"
HOMEPAGE = "http://openzwave.com/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://license/license.txt;md5=584c7ddacb8739db77ddcc47bd9d3b52"

PR = "r0"

DEPENDS = "systemd"

SRC_URI = "http://old.openzwave.com/snapshots/openzwave-${PV}.tar.gz \
           file://main-support-mk.diff \
"

SRC_URI[md5sum] = "438cf4b2da4116de071abcb430d3a006"
SRC_URI[sha256sum] = "042a4bbc12a7dc2175d0b8d5831e3ba36653557118a190de0450e486dac61d71"

inherit autotools-brokensep pkgconfig systemd

do_compile_prepend() {
  export BITBAKE_ENV=1
}

do_install() {
  oe_runmake \
      'DESTDIR=${D}' \
      'PREFIX=${prefix}' \
      'docdir=${docdir}/${PN}-${PV}' \
      install
}
