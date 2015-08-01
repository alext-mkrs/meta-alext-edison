SUMMARY = "Kernel module to create V4L2 loopback devices"
SECTION = "libs"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "help2man-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/umlaeute/v4l2loopback;protocol=https \
           file://correct_kernel_src_path.patch \
           file://added_makefile_target_for_yocto.patch \
           file://corrected_path_to_help2man.patch \
"

PV = "0.9.1+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit module

do_compile_append() {
    oe_runmake man/v4l2loopback-ctl.1 YOCTO_NATIVE_BINDIR=${STAGING_BINDIR_NATIVE}
}

do_install_append() {
    # util binary
    install -m 755 -D utils/v4l2loopback-ctl ${D}${bindir}/v4l2loopback-ctl
    # man page
    install -m 644 -D man/v4l2loopback-ctl.1 ${D}${mandir}/v4l2loopback-ctl.1

}

FILES_${PN} += "${bindir}/v4l2loopback-ctl"

