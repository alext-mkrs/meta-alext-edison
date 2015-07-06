DESCRIPTION = "Utility to stream MJPG webcam data over network"
HOMEPAGE = "http://sourceforge.net/projects/mjpg-streamer/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

DEPENDS = "jpeg libv4l"
RDEPENDS_${PN} = "jpeg libv4l"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "svn://svn.code.sf.net/p/mjpg-streamer/code/;module=mjpg-streamer;rev=182;scmdata=keep"
S = "${WORKDIR}/mjpg-streamer"

#inherit autotools gettext

EXTRA_OEMAKE = " USE_LIBV4L2=true \
                 CC="${CC}" \
"

do_install() {
  install -d ${D}/lib
  install -d ${D}/bin  
  oe_runmake 'DESTDIR=${D}' install
}

FILES_${PN} += " /lib/* \
             	 /www \
"

PACKAGES = "${PN} ${PN}-dbg"
