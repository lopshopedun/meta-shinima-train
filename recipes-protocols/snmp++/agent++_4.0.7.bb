DESCRIPTION = "A C++ Agent SNMP library that supports SNMPv1, SNMPv2c and SNMPv3"
LICENSE = "CLOSED"
#SECTION = "libs"
#PRIORITY = "optional"
#DEPENDS = "libdes libtomcrypt"
DEPENDS = "openssl snmp++"

SRC_URI = "http://agentpp.com/download/agent++-${PV}.tar.gz"
SRC_URI[md5sum] = "5d44ec8edff056c62832ea5f0b5effcd"
SRC_URI[sha256sum] = "6775fa2a038801edddedc148d7846427ddc4d438e3bb33362d9eec6074918a88"


S = "${WORKDIR}/${PN}-${PV}"

#CFLAGS_append = " -I../include"

#do_compile() {
#	oe_runmake -f Makefile.linux LIBDESDIR=${STAGING_LIBDIR} LIBTOMCRYPTDIR=${STAGING_LIBDIR}
#}

#do_stage() {
#	oe_libinstall -a -C ../lib libsnmp++ ${STAGING_LIBDIR}/
#	install -d ${STAGING_INCDIR}/snmp++
#	install -m 0644 ../include/*.h ${STAGING_INCDIR}/snmp++
#}

inherit pkgconfig autotools

