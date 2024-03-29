# Image for Beagleboard-based robots

require recipes-images/angstrom/systemd-image.bb

DEPENDS += " \
	    libtirpc \
	    linux-firmware \
	    gst-plugins-base \
	    gst-plugins-good \
	    gst-plugins-ugly \
	    minicom \
	    avrdude \
	    ntp \
	   "

IMAGE_INSTALL += " \
	     libtirpc \
	     linux-firmware \
	     kernel-module-rt2x00usb \
	     kernel-module-rt2800usb \
	     kernel-module-uvcvideo \
	     kernel-module-snd-usb-audio \
	     kernel-module-ftdi-sio \
	     i2c-tools \
	     alsa-utils-amixer \
	     alsa-utils-aplay \
	     gst-plugins-base-audioconvert \
	     gst-plugins-base-audioresample \
	     gst-plugins-base-alsa \
	     gst-plugins-ugly-mad \
	     python-pygobject \
	     python-dbus \
	     connman-tests \
	     minicom \
	     avrdude \
	     espeak \
	     ntp \
	    "

export IMAGE_BASENAME = "robot-image"
