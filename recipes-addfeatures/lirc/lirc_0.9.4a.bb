require lirc.inc

SRC_URI += " \
    file://lircd.service \
    file://lircd.init \
    file://lircexec.init \
    file://lircd.conf \
    file://lirc_options.conf \
    file://lirc.tmpfiles \
"

SRC_URI[md5sum] = "d38566cb159c864089c24f2fcc7c5ccc"
SRC_URI[sha256sum] = "386086a74c7d12e7e8f26f7dbc8f40d20b9968c9ad2a42599483a51dd2da03ba"

SYSTEMD_PACKAGES = "lirc"
SYSTEMD_SERVICE_${PN} = "lircd.service lircmd.service irexec.service lircd-uinput.service"
SYSTEMD_AUTO_ENABLE_lirc = "disable"

inherit autotools pkgconfig systemd python3native

PACKAGECONFIG[systemd] = "--with-systemdsystemunitdir=${systemd_unitdir}/system/,--without-systemdsystemunitdir,systemd"
PACKAGECONFIG[x11] = "--with-x,--with-x=no,libx11,"

PACKAGECONFIG ?= " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' systemd', '', d)} \
"

do_install_append() {
    install -m 0755 -d ${D}${sysconfdir}
    install -m 0755 -d ${D}${sysconfdir}/lirc
    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0755 -d ${D}${libdir}/tmpfiles.d
    install -m 0644 ${WORKDIR}/lircd.conf ${D}${sysconfdir}/lirc/
    install -m 0644 ${WORKDIR}/lirc_options.conf ${D}${sysconfdir}/lirc/
    install -m 0644 ${WORKDIR}/lircd.service ${D}${systemd_unitdir}/system/
    install -m 0755 ${WORKDIR}/lircexec.init ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/lirc.tmpfiles ${D}${libdir}/tmpfiles.d/lirc.conf
    rm -rf ${D}${libdir}/lirc/plugins/*.la
    rmdir ${D}/var/run/lirc ${D}/var/run
}

PACKAGES =+ "${PN}-contrib ${PN}-exec ${PN}-plugins ${PN}-python"

RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-exec = "${PN}"
RDEPENDS_${PN}-python = "python"

RRECOMMENDS_lirc = "${PN}-exec ${PN}-plugins"

FILES_${PN}-plugins = "${libdir}/lirc/plugins/*.so ${datadir}/lirc/configs"
FILES_${PN}-contrib = "${datadir}/lirc/contrib"
FILES_${PN}-exec = "${bindir}/irexec ${sysconfdir}/lircexec"
FILES_${PN} += "${systemd_unitdir}/system/lircexec.init"
FILES_${PN} += "${systemd_unitdir}/system/lircd.service"
FILES_${PN} += "${systemd_unitdir}/system/lircd.socket"
FILES_${PN} += "${libdir}/tmpfiles.d/lirc.conf"
FILES_${PN}-dbg += "${libdir}/lirc/plugins/.debug"
FILES_${PN}-python += "${libdir}/python*/site-packages"


INITSCRIPT_PACKAGES = "lirc lirc-exec"
INITSCRIPT_NAME_lirc-exec = "lircexec"
INITSCRIPT_PARAMS_lirc-exec = "defaults 21"

# this is for distributions that don't use udev
pkg_postinst_${PN}_append() {
    if [ ! -c $D/dev/lirc -a ! -f /sbin/udevd ]; then mknod $D/dev/lirc c 61 0; fi
}
