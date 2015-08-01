DESCRIPTION = "A comprehensive software suite for reading barcodes"
HOMEPAGE = "http://zbar.sourceforge.net/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=243b725d71bb5df4a1e5920b344b86ad"

DEPENDS = "v4l-utils jpeg libxv util-linux libice libsm"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "http://downloads.sourceforge.net/project/${PN}/${PN}/${PV}/${PN}-${PV}.tar.bz2 \
           file://fixed_am_prog_ar_warning.patch \
           file://Silenced-automake-warnings.patch \
           file://Fixed-v4l1-header-name.patch \
           file://Fixed-v4l1-include.patch \
           file://Fixed-Python-include.patch \
"

SRC_URI[md5sum] = "0fd61eb590ac1bab62a77913c8b086a5"
SRC_URI[sha256sum] = "234efb39dbbe5cef4189cc76f37afbe3cfcfb45ae52493bfe8e191318bdbadc6"

#FILES_${PN} += "${datadir}/${PN}-${PV}"

inherit autotools-brokensep gettext pkgconfig distutils-base python-dir

EXTRA_OECONF = "--without-imagemagick \
                --without-gtk \
                --without-qt \
"

