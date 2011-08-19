# Image for Beagleboard-based robots

require recipes-angstrom/images/console-image.bb

DEPENDS += " \
	    linux-firmware \
	    gst-plugins-base \
	    gst-plugins-ugly \
	    minicom \
	    avrdude \
	    ntp \
	   "

IMAGE_INSTALL += " \
	     linux-firmware-rt2x00 \
	     kernel-module-rt2x00usb \
	     kernel-module-rt2800usb \
	     alsa-utils-amixer \
	     alsa-utils-aplay \
	     connman-plugin-ntpd \
	     gst-plugins-base-audioconvert \
	     gst-plugins-base-audioresample \
	     gst-plugins-base-alsa \
	     gst-plugins-ugly-mad \
	     minicom \
	     avrdude \
	     espeak \
	     ntp \
	    "

export IMAGE_BASENAME = "robot-image"
