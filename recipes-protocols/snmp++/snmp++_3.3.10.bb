DESCRIPTION = "A C++ SNMP library that supports SNMPv1, SNMPv2c and SNMPv3"
LICENSE = "CLOSED"
#DEPENDS = "libdes libtomcrypt"
DEPENDS = "openssl"

inherit pkgconfig autotools

SRC_URI = "http://agentpp.com/download/snmp++-${PV}.tar.gz"
SRC_URI[md5sum] = "86b0ca6db46542894b7054039f1b6623"
SRC_URI[sha256sum] = "6827adb6a6a68a7f32c41fa12bdfd0aa48f4825b8773f63fc4d5c8482d4ed481"

SRC_URI += "file://snmp_disable_logging.patch"


S = "${WORKDIR}/${PN}-${PV}"

#do_compile() {
#	oe_runmake -f Makefile.linux LIBDESDIR=${STAGING_LIBDIR} LIBTOMCRYPTDIR=${STAGING_LIBDIR}
#}

#do_stage() {
#	oe_libinstall -a -C ../lib libsnmp++ ${STAGING_LIBDIR}/
#	install -d ${STAGING_INCDIR}/snmp++
#	install -m 0644 ../include/*.h ${STAGING_INCDIR}/snmp++
#}

EXTRA_OECONF += " --disable-logging --enable-snmpv3 --with-ssl "

#do_install_append() {
#	rm ${D}/${bindir}/receive_trap
#}
