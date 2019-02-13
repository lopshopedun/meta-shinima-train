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
	libslabhid \
	snmp++ \
"
# add iptables later
RDEPENDS_packagegroup-shinima-mandatory = "\
	libcap \
	libcap-ng \
	gpsd \
	python-pygps \
	gps-utils \
	gpsd-conf \
	minicom \
	rsyslog \
"

RRECOMMENDS_packagegroup-shinima-mandatory = ""
RRECOMMENDS_packagegroup-shinima-debug = ""

pkg_postinst_${PN}() {
    if [ x"$D" = "x" ]; then
        # Actions to carry out on the device go here
	# Soft link creation to our Qt's apps could run:
	ln -sf /lib/ld-linux-armhf.so.3 /lib/ld-linux.so.3
    else
        exit 1
    fi
}
