FILESEXTRAPATHS_prepend := "${THISDIR}/rsyslog:"

SRC_URI += " \
    file://rsyslog.conf \
"

do_install_append() {
    install -m 644 ${WORKDIR}/rsyslog.conf ${D}${sysconfdir}/rsyslog.conf
}
