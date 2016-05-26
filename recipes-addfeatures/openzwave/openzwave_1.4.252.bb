DESCRIPTION = "free software library that interfaces with selected Z-Wave PC controllers"
HOMEPAGE = "http://openzwave.com/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://license/license.txt;md5=584c7ddacb8739db77ddcc47bd9d3b52"

PR = "r0"

DEPENDS = "systemd"

SRC_URI = "http://old.openzwave.com/snapshots/openzwave-${PV}.tar.gz \
           file://main-support-mk.diff \
"

SRC_URI[md5sum] = "984d2202d2dbc010fb19e09b236408b9"
SRC_URI[sha256sum] = "dc141ce510604381519ca8c5c8dfb70717bfab6b12bada0411625d277449641e"

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
