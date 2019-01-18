SUMMARY = "Custom Package Groups for shinima-train project"
DESCRIPTION = "Package Groups required to run orchestrator in debug configuration"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "packagegroup-shinima-mandatory \
	    packagegroup-shinima-debug \
"
			
RDEPENDS_${PN} = "\
	packagegroup-shinima-mandatory \
	ldd \
	file \
	ltrace \
	strace \
	dstat \
	tcpdump \
	valgrind \
	lsof \
	netcat \
	curl \
	vsftpd \
	net-snmp \
	slabhid \
"

RDEPENDS_packagegroup-shinima-mandatory = "\
	libcap \
	libcap-ng \
	gpsd \
	minicom \
"

RRECOMMENDS_packagegroup-shinima-mandatory = ""
RRECOMMENDS_packagegroup-shinima-debug = ""

