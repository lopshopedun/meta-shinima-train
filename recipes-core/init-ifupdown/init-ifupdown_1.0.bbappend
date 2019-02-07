FILESEXTRAPATHS_prepend := "${THISDIR}/init-ifupdown:"

SRC_URI_append = " \
	file://interfaces \
"
