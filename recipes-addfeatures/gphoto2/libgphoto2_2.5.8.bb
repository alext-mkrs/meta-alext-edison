SUMMARY = "libgphoto2 allows you to access digital cameras"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=0448d3676bc0de00406af227d341a4d1"

DEPENDS = "libtool jpeg virtual/libusb0 libexif libxml2"

# The .fdi, .rules and .conf files were generated directly on Edison with:
#   /usr/lib/libgphoto2/print-camera-list hal-fdi > /home/root/10-camera-libgphoto2.fdi
#   /usr/lib/libgphoto2/print-camera-list hal-fdi-device > /home/root/10-camera-libgphoto2-device.fdi
#   /usr/lib/libgphoto2/print-camera-list udev-rules version 201 > /home/root/40-libgphoto2.rules
#   /usr/lib/libgphoto2/print-camera-list hwdb > /home/root/20-gphoto.conf
# They are release specific, so please regen when adding new releases

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/libgphoto2-${PV}.tar.bz2;name=libgphoto2 \
           file://0001-configure.ac-remove-AM_PO_SUBDIRS.patch \
           file://10-camera-libgphoto2.fdi \
           file://10-camera-libgphoto2-device.fdi \
           file://40-libgphoto2.rules \
           file://20-gphoto.conf \
"

SRC_URI[libgphoto2.md5sum] = "873ab01aced49c6b92a98e515db5dcef"
SRC_URI[libgphoto2.sha256sum] = "031a262e342fae43f724afe66787947ce1fb483277dfe5a8cf1fbe92c58e27b6"

inherit autotools pkgconfig gettext lib_package

EXTRA_OECONF = " udevscriptdir=/lib/udev"

PACKAGECONFIG ??= "gd serial"
PACKAGECONFIG[gd] = "--with-gdlib=auto,--with-gdlib=no,gd"
PACKAGECONFIG[serial] = "--enable-serial,--disable-serial,lockdev"

do_configure_append() {
    cp ${STAGING_DATADIR}/gettext/po/Makefile.in.in ${S}/libgphoto2_port/po/
    cd ${S}/libgphoto2_port/
    autoreconf -Wcross --verbose --install --force ${EXTRA_AUTORECONF} $acpaths
    cd ${S}
}

do_install_append() {
    install -d ${D}${datadir}/hal/fdi/information/20thirdparty
    install -m 0644 ${WORKDIR}/*.fdi ${D}${datadir}/hal/fdi/information/20thirdparty/

    install -d ${D}${base_libdir}/udev/rules.d/
    install -m 0755 ${WORKDIR}/*.rules ${D}${base_libdir}/udev/rules.d/

    install -d ${D}${base_libdir}/udev/hwdb.d/
    install -m 0755 ${WORKDIR}/20-gphoto.conf ${D}${base_libdir}/udev/hwdb.d/20-gphoto.conf
}

PACKAGES =+ "libgphotoport libgphoto2-camlibs"
FILES_libgphoto2-camlibs = "${libdir}/libgphoto2*/*/*.so*"
RRECOMMENDS_${PN} = "libgphoto2-camlibs"
RDEPENDS_${PN} = "bash"

FILES_libgphotoport = "${libdir}/libgphoto2_port.so.*"

FILES_${PN} += "${base_libdir}/udev/* ${datadir}/hal"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"
FILES_${PN}-dev += "${libdir}/*/*/*.la"

