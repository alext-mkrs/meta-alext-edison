DESCRIPTION = "free software library that interfaces with selected Z-Wave PC controllers"
HOMEPAGE = "http://openzwave.com/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://license/license.txt;md5=584c7ddacb8739db77ddcc47bd9d3b52"

PR = "r0"

DEPENDS = "systemd"

SRC_URI = "http://old.openzwave.com/snapshots/openzwave-${PV}.tar.gz \
           file://main-makefile.diff \
           file://main-support-mk.diff \
           file://minozw-makefile.diff \
"

SRC_URI[md5sum] = "43b48ac2b0a5f69161c19637267851cc"
SRC_URI[sha256sum] = "02de82db72ca6646b401e40c9c8d05fac109e173847576b4e4d700e44623d136"

inherit autotools-brokensep pkgconfig systemd

do_install() {
  oe_runmake \
      'DESTDIR=${D}' \
      'PREFIX=${prefix}' \
      'docdir=${docdir}/${PN}-${PV}' \
      install
}
