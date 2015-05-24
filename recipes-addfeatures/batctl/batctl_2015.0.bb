DESCRIPTION = "Control application for B.A.T.M.A.N. routing protocol kernel module for multi-hop ad-hoc mesh networks."
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.c;beginline=2;endline=18;md5=dbe42c1c4d287355c726983c326dc239"

INC_PR = "r0"
PR = "${INC_PR}.0"

RDEPENDS_${PN} = "kernel-module-batman-adv"
DEPENDS = "libnl"

SRC_URI = "http://downloads.open-mesh.net/batman/stable/sources/batctl/batctl-${PV}.tar.gz"

SRC_URI[md5sum] = "d28ad89d71888ad6b99a1f6b30c9d47c"
SRC_URI[sha256sum] = "634d91189f96bda6d4ce6179dce90ad578566f29d3111b49d6e775d4f3591f04"

EXTRA_OEMAKE = "-I${STAGING_INCDIR}"

do_install() {
   oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir}
}
