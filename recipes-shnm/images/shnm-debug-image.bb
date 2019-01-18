include recipes-axl/images/axl-image-base.bb
include recipes-core/packagegroups/packagegroup-shinima-project.bb

IMAGE_INSTALL += " \
	packagegroup-shinima-mandatory \
	packagegroup-shinima-debug \
"

export IMAGE_BASENAME = "shnm-debug-image"
