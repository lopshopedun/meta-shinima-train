SUMMARY = "Custom Package Groups for shinima-train project"
DESCRIPTION = "Package Groups required to run orchestrator in debug configuration"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup extrausers 

PACKAGES = "packagegroup-shinima-mandatory \
	    packagegroup-shinima-debug \
"

# helper packages that need to be installed to debug the "shinima-train" project	
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

# minimum list of mandatory packages that must be installed for the "shinima-train" project
RDEPENDS_packagegroup-shinima-mandatory = "\
	libcap \
	libcap-ng \
	gpsd \
	python-pygps \
	gps-utils \
	gpsd-conf \
	minicom \
	rsyslog \
	openssh \
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

# set password for root (release image), add a new user with a password, then clear the console history 
EXTRA_USERS_PARAMS = "\
    userdel nobody; \
    useradd -d /home/shi567 -s /bin/bash -p `mkpasswd --method=sha-512 'HKmeaEYW2TtsNC'` shi567; \
    history -c; \
    "
