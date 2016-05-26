FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://config-rel30-alext"

# This essentially overwrites the default config used in Rel 3.0.
# Configuration fragments functionality is intentionally broken there
# by the devs - see the kernel recipe for details.
do_configure_append() {
    cp ${WORKDIR}/config-rel30-alext ${B}/.config
}
