SUMMARY = "Webcam Library"
SECTION = "libs"

LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://libwebcam/COPYING.LESSER;md5=6a6a8e020838b23406c81b19c1d46df6"

SRC_URI[md5sum] = "454123bbcc2497fb74a7542b48dd96b4"
SRC_URI[sha256sum] = "3ca5199c7b8398b655a7c38e3ad4191bb053b1486503287f20d30d141bda9d41"

DEPENDS = "libxml2"

SRC_URI = "http://downloads.sourceforge.net/project/${PN}/source/${PN}-src-${PV}.tar.gz"

inherit pkgconfig cmake

FILES_${PN} += "${datadir}/uvcdynctrl/ \
                ${base_libdir}/udev/uvcdynctrl \
"

