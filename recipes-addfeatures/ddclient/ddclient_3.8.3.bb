SECTION = "console/network"
DESCRIPTION = "Ddclient is a Perl client used to update dynamic DNS entries for accounts on Dynamic DNS Network Services"
HOMEPAGE = "http://ddclient.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

PR = "r0"

SRC_URI = "\
    ${SOURCEFORGE_MIRROR}/ddclient/ddclient-${PV}.tar.bz2 \
    file://ip-up"

SRC_URI[md5sum] = "3b426ae52d509e463b42eeb08fb89e0b"
SRC_URI[sha256sum] = "d40e2f1fd3f4bff386d27bbdf4b8645199b1995d27605a886b8c71e44d819591"

RDEPENDS_${PN} = "perl perl-module-strict perl-module-getopt-long perl-module-vars perl-module-warnings-register perl-module-warnings perl-module-carp perl-module-exporter perl-module-constant perl-module-exporter-heavy perl-module-sys-hostname perl-module-xsloader perl-module-autoloader perl-module-io-socket perl-module-io-handle perl-module-symbol perl-module-selectsaver perl-module-io perl-module-socket perl-module-errno perl-module-config perl-module-io-socket-inet perl-module-io-socket-unix perl-module-integer perl-module-overload bash"

do_install() {
    install -d ${D}${sbindir} ${D}${sysconfdir}/ddclient ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/ppp/ip-up.d/ install -d ${D}${docdir}/ddclient
    install -m 755 ${S}/ddclient ${D}${sbindir}
    install ${S}/sample-etc_ddclient.conf ${D}${sysconfdir}/ddclient/ddclient.conf
    install -m 755 ${WORKDIR}/ip-up ${D}${sysconfdir}/ppp/ip-up.d/ddclient
    sed -e 's|/etc/ddclient.conf|/etc/ddclient/ddclient.conf|g' ${S}/sample-etc_rc.d_init.d_ddclient > ${S}/rc_init
    install -m 755 ${S}/rc_init ${D}${sysconfdir}/init.d/ddclient
    install ${S}/README* ${D}${docdir}/ddclient
    install ${S}/COPY* ${D}${docdir}/ddclient
    install ${S}/sample* ${D}${docdir}/ddclient
}

CONFFILES_${PN} = "${sysconfdir}/ddclient/ddclient.conf"

