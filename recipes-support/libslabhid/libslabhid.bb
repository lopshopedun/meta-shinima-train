DESCRIPTION = "libraries libslabhid* to manage variable attenuator in debug configuration of shinima-train project"
LICENSE = "MIT"
PV = "1"
PR = "r0"

DEPENDS = "libusb1"

SRC_URI = " \
	file://usr/lib/libslabhiddevice.a \
	file://usr/lib/libslabhiddevice.so.1.0 \
	file://usr/lib/libslabhidtouart.a \
	file://usr/lib/libslabhidtouart.so.1.0 \
"

FILES_SOLIBSDEV = ""
S = "${WORKDIR}"

do_install () {
	install -d ${D}${libdir}
	install -m 0755 ${WORKDIR}/usr/lib/*			${D}${libdir}
	ln -sf ${libdir}/libslabhiddevice.so.1.0	${D}${libdir}/libslabhiddevice.so.1
	ln -sf ${libdir}/libslabhidtouart.so.1.0	${D}${libdir}/libslabhidtouart.so.1
}

FILES_${PN} += "${libdir}/*"
INSANE_SKIP_${PN} += "dev-so"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
