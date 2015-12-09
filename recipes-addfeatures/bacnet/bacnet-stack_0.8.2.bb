DESCRIPTION = "BACnet open source protocol stack for embedded systems"
HOMEPAGE = "http://bacnet.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.txt;md5=3040850b26eed151876dcd4b841f5235"

PR = "r0"

RDEPENDS_${PN} = "bash"

SRC_URI = "http://sourceforge.net/projects/bacnet/files/bacnet-stack/bacnet-stack-${PV}/bacnet-stack-${PV}.tgz \
"

SRC_URI[md5sum] = "cb7d0bc58bfe36ce3789923b9e5acd2d"
SRC_URI[sha256sum] = "4646d3148b9e2921f0c93605fb7a18d87224dcad3adc3127762f3788f9a13f04"

inherit autotools-brokensep

do_install() {
  # main library file
  install -D -m 0644 ${S}/lib/libbacnet.a ${D}${libdir}/libbacnet.a
  
  # includes
  install -d ${D}${includedir}/${PN}/
  install -m 0644 ${S}/include/* ${D}${includedir}/${PN}/

  # demos & docs
  install -d ${D}${bindir}/
  install -m 0755 ${S}/bin/* ${D}${bindir}/
  install -D -m 0644 ${S}/bin/readme.txt ${D}$docdir/${PN}/readme.txt
  rm -rf ${D}${bindir}/readme.txt
  rm -rf ${D}${bindir}/bacrpd.bat
  rm -rf ${D}${bindir}/bvlc.bat
}
