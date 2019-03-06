FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += " \
    file://cron-utilities.cfg \
    file://ftp-utilities.cfg \
    file://telnetd-utilities.cfg \
"
