DESCRIPTION = "Linux Infrared Remote Control"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PR = "r0"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "http://downloads.sourceforge.net/project/${PN}/LIRC/${PV}/${PN}-${PV}.tar.gz \
           file://replaced-libsystemd-daemon-with-libsystemd.patch \
"

SRC_URI[md5sum] = "c9154bf61947dde0ba1b91f7dd54c2e5"
SRC_URI[sha256sum] = "5da1341fac3dc3c191c2ae82c2ee1045206db40c47637684ca2ad8cf538b6f61"

DEPENDS = "systemd jack libusb-compat libusb1 portaudio-v19"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-systemdsystemunitdir=${systemd_unitdir}/system"

do_install_append() {
    rm ${D}/configs
}

FILES_${PN} += "/run"
FILES_${PN}-dbg += "/usr/lib/lirc/plugins/.debug"

inherit systemd

SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE_${PN} = "lircd.service lircd.socket lircmd.service"

