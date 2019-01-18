DESCRIPTION = "AgentX library for support subagents in agent++"
LICENSE = "CLOSED"
#SECTION = "libs"
#PRIORITY = "optional"
#DEPENDS = "libdes libtomcrypt"
DEPENDS = "snmp++ agent++"

SRC_URI = "http://agentpp.com/download/agentx++-${PV}.tar.gz"
SRC_URI[md5sum] = "b88081ed61446d99b7f57eb57b971220"
SRC_URI[sha256sum] = "d5ae09ec7b129bcf2a9d918336cad42b15d9b0ae58891ee7481e9ee0853fe3a5"


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

