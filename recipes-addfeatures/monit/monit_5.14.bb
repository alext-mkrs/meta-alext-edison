LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea116a7defaf0e93b3bb73b2a34a3f51"
DEPENDS = "openssl"

# mmonit.com has really weird traffic shaping policy...
MIRRORS_append = " http://mmonit.com/monit/dist/.*     http://fossies.org/linux/privat/ \n \
                   http://mmonit.com/monit/dist/.*     https://github.com/William-Yeh/ansible-monit-tarball/releases/download/5.14/ \n \
"

SRC_URI = "\
           http://mmonit.com/monit/dist/monit-${PV}.tar.gz \
           file://enable-etc-monit.d-include.patch \
"

SRC_URI[md5sum] = "1b3ae1eb08a0914402a8764e5689c1c5"
SRC_URI[sha256sum] = "d0424c3ee8ed43d670ba039184a972ac9f3ad6f45b0806ec17c23820996256c6"

inherit autotools-brokensep systemd

EXTRA_OECONF = "\
	libmonit_cv_setjmp_available=yes \
        libmonit_cv_vsnprintf_c99_conformant=yes \
        --with-ssl-lib-dir=${STAGING_LIBDIR} \
        --with-ssl-incl-dir=${STAGING_INCDIR} \
	--without-pam \
        "

do_install_append() {
	sed -i 's:# set daemon  120:set daemon  120:' ${S}/monitrc
	sed -i 's:include /etc/monit.d/:include /${sysconfdir}/monit.d/:' ${S}/monitrc
	install -d ${D}${sysconfdir}
	install -m 600 ${S}/monitrc ${D}${sysconfdir}/monitrc
	install -m 700 -d ${D}${sysconfdir}/monit.d/
	install -d ${D}${systemd_unitdir}/system
	install -m 755 ${S}/system/startup/monit.service ${D}${systemd_unitdir}/system
}

CONFFILES_${PN} += "${sysconfdir}/monitrc"
SYSTEMD_SERVICE_${PN} = "monit.service"
