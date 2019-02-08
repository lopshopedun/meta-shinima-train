FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://gpsd \
"

do_install_append() {
    install -m 0755 ${WORKDIR}/gpsd ${D}/${sysconfdir}/init.d/
}
