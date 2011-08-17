PR_append = "a"

do_install_append() {
	# Ralink drivers
	install -m 0644 rt2860.bin ${D}/lib/firmware/rt2860.bin
	install -m 0644 rt2870.bin ${D}/lib/firmware/rt2870.bin
	install -m 0644 rt2561.bin ${D}/lib/firmware/rt2561.bin
	install -m 0644 rt2561s.bin ${D}/lib/firmware/rt2561s.bin
	install -m 0644 rt2661.bin ${D}/lib/firmware/rt2661.bin
	install -m 0644 rt73.bin ${D}/lib/firmware/rt73.bin
	install -m 0644 LICENCE.ralink-firmware.txt ${D}/lib/firmware/LICENCE.ralink-firmware.txt
}

PACKAGES += "${PN}-rt2x00"

FILES_${PN}-rt2x00 = " \
	/lib/firmware/rt2860.bin \
	/lib/firmware/rt2870.bin \
	/lib/firmware/rt2561.bin \
	/lib/firmware/rt2561s.bin \
	/lib/firmware/rt2661.bin \
	/lib/firmware/rt73.bin \
	/lib/firmware/LICENCE.ralink-firmware.txt \
	"

RPROVIDES_${PN}-rt2x00 = "${PN}-rt2x00"
