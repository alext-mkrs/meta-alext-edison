DESCRIPTION = "The ARP scanner"
HOMEPAGE = "http://www.nta-monitor.com/tools-resources/security-tools/arp-scan"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"

DEPENDS = "libpcap"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "http://www.nta-monitor.com/files/arp-scan/arp-scan-${PV}.tar.gz \
           file://adjust_configure_ac.patch \
"

SRC_URI[md5sum] = "38584d6c1edfa9f6b41d496e4a5539f1"
SRC_URI[sha256sum] = "ce908ac71c48e85dddf6dd4fe5151d13c7528b1f49717a98b2a2535bd797d892"

inherit autotools

