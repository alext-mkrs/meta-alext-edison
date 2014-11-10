DESCRIPTION = "Mixed-level/mixed-signal circuit simulator"
HOMEPAGE = "http://ngspice.sourceforge.net"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=756965e8cd0fbaca1738b60a069a19f8"

PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/project/${PN}/ng-spice-rework/${PV}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "7fd9cdd11b1bb109eb48201222de4c50"
SRC_URI[sha256sum] = "51e230c8b720802d93747bc580c0a29d1fb530f3dd06f213b6a700ca9a4d0108"

inherit autotools gettext

EXTRA_OECONF = "--with-x --enable-xspice --enable-cider --with-readline=yes --enable-openmp"

# Without this it fails not being able to find omp.h.
# This looks like a hack to me, but is good enough for now.
CFLAGS_prepend = " -I${STAGING_LIBDIR}/gcc/${TARGET_SYS}/4.8.2/include"

PACKAGES = "${PN} ${PN}-doc ${PN}-dbg"

