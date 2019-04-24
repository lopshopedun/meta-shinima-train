include recipes-axl/images/axl-image-base.bb

IMAGE_INSTALL += " \
	packagegroup-shinima-debug \
"

export IMAGE_BASENAME = "axl-shnm-debug-image"
