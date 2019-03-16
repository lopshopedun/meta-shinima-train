FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "5f6f0a50e6039370078369ddf380179d59024789"
SRC_URI_append_rsb10x = " \
    file://rsb10x/defconfig \
"

do_copy_defconfig_append() {
    cp -v ${WORKDIR}/rsb10x/defconfig ${B}/.config
    cp -v ${WORKDIR}/rsb10x/defconfig ${B}/../defconfig
}

LOCALVERSION = "-RSB10X-125-004"
SCMVERSION = "n"
