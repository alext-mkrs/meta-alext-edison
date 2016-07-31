DESCRIPTION = "The ARP scanner"
HOMEPAGE = "http://www.nta-monitor.com/tools-resources/security-tools/arp-scan"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r1"

DEPENDS = "libpcap"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "https://github.com/royhills/arp-scan/archive/${PV}.tar.gz \
           file://adjust_configure_ac.patch \
"

SRC_URI[md5sum] = "38cee90a5af3e4ac96a853467ec1c769"
SRC_URI[sha256sum] = "b2a446a170e4a2feeb825cd08db48a147f8dffae702077f33e456c4200e7afb0"

inherit autotools

