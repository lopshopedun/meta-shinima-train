FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += " \
    file://ftp-utilities.cfg \
    file://telnetd-utilities.cfg \
"
