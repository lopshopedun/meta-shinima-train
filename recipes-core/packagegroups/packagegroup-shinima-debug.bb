SUMMARY = "Debug Package Group for shinima project"
DESCRIPTION = "Helper packages that need to be installed to debug the shinima project on real or test equipment"
PR = "r0"
LICENSE = "MIT" 

inherit packagegroup

PACKAGES = "packagegroup-shinima-minimal \
	packagegroup-shinima-debug \
"
	
RDEPENDS_${PN} = "\
	packagegroup-shinima-minimal \
	ldd \
	file \
	ltrace \
	strace \
	dstat \
	tcpdump \
	valgrind \
	gdb \
	lsof \
	netcat \
	htop \
	curl \
	libslabhid \
"

# Minimum group of packets with which the shinima project can be successfully run
RDEPENDS_packagegroup-shinima-minimal = "\
	libcap \
	libcap-ng \
	gpsd \
	python-pygps \
	gps-utils \
	gpsd-conf \
	minicom \
	rsyslog \
	openssh \
	net-snmp \
	snmp++ \
	jq \
"

PACKAGE_EXCLUDE_packagegroup-shinima-debug += "wvdial ofono"

RRECOMMENDS_packagegroup-shinima-minimal = ""
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
