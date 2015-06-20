# We need to remove host-specific paths from tclConfig.sh.
# The original recipe leaves them behind.

do_install_append_class-target() {
	# original recipe steps out of the build dir
	cd ${B}
        sed -i 's# --sysroot='${PKG_CONFIG_SYSROOT_DIR}'##' tclConfig.sh
        sed -i 's#'${PKG_CONFIG_SYSROOT_DIR}'##' tclConfig.sh
}
