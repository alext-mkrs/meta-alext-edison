SUMMARY = "ImageMagick is an image convertion tools"
SECTION = "console/utils"
LICENSE = "ImageMagick"
LIC_FILES_CHKSUM = "file://LICENSE;md5=22d47a47bf252ca3ed7f71273b53612e"
# FIXME: There are many more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "lcms bzip2 jpeg libpng librsvg tiff zlib virtual/fftw freetype"

# Important note: tarballs for all patchsets within a version are deleted when
# a new pachset is created. To avoid multiple patches for each patchset, try to
# update to the last pachset of a version
PATCHSET = "10"
SRC_URI = "http://www.imagemagick.org/download/releases/ImageMagick-${PV}-${PATCHSET}.tar.xz \
"

SRC_URI[md5sum] = "d3b361617d147d1a8f58a77930db3d0d"
SRC_URI[sha256sum] = "da2f6fba43d69f20ddb11783f13f77782b0b57783dde9cda39c9e5e733c2013c"

S = "${WORKDIR}/ImageMagick-${PV}-${PATCHSET}"

inherit autotools pkgconfig update-alternatives

# xml disabled because it's using xml2-config --prefix to determine prefix which returns just /usr with our libxml2
# if someone needs xml support then fix it first
EXTRA_OECONF = "--program-prefix= --program-suffix=.im6 --without-x --without-perl --disable-openmp --without-xml --disable-opencl"

CACHED_CONFIGUREVARS = "ac_cv_sys_file_offset_bits=yes"
PACKAGECONFIG ??= ""
PACKAGECONFIG[jp2] = "--with-jp2,,jasper"
PACKAGECONFIG[lzma] = "--with-lzma,--without-lzma,xz"
PACKAGECONFIG[openjpeg] = "--with-openjp2,--without-openjp2,openjpeg"
PACKAGECONFIG[pango] = "--with-pango,--without-pango,pango cairo"
PACKAGECONFIG[webp] = "--with-webp,--without-webp,libwebp"
PACKAGECONFIG[wmf] = "--with-wmf,--without-wmf,libwmf"

FILES_${PN} += "${libdir}/ImageMagick-${PV}/modules-Q16/*/*.so \
                ${libdir}/ImageMagick-${PV}/modules-Q16/*/*.la \
                ${libdir}/ImageMagick-${PV}/modules-Q16/filters \
                ${libdir}/ImageMagick-${PV}/modules-Q16/coders \
                ${libdir}/ImageMagick-${PV}/config-Q16 \
                ${datadir}/ImageMagick-6 "

FILES_${PN}-dev += "${libdir}/ImageMagick-${PV}/modules-Q16/*/*.a"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${PV}/modules-Q16/*/.debug/*"

BBCLASSEXTEND = "native"

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE_${PN} = "animate compare composite conjure convert display \
    identify import mogrify montage stream"

ALTERNATIVE_TARGET[animate] = "${bindir}/animate.im6"
ALTERNATIVE_TARGET[compare] = "${bindir}/compare.im6"
ALTERNATIVE_TARGET[composite] = "${bindir}/composite.im6"
ALTERNATIVE_TARGET[conjure] = "${bindir}/conjure.im6"
ALTERNATIVE_TARGET[convert] = "${bindir}/convert.im6"
ALTERNATIVE_TARGET[display] = "${bindir}/display.im6"
ALTERNATIVE_TARGET[identify] = "${bindir}/identify.im6"
ALTERNATIVE_TARGET[import] = "${bindir}/import.im6"
ALTERNATIVE_TARGET[mogrify] = "${bindir}/mogrify.im6"
ALTERNATIVE_TARGET[montage] = "${bindir}/montage.im6"
ALTERNATIVE_TARGET[stream] = "${bindir}/stream.im6"

ALTERNATIVE_${PN}-doc = "animate.1 compare.1 composite.1 conjure.1 \
    convert.1 display.1 identify.1 import.1 mogrify.1 montage.1 stream.1"

ALTERNATIVE_LINK_NAME[animate.1] = "${mandir}/man1/animate.1"
ALTERNATIVE_TARGET[animate.1] = "${mandir}/man1/animate.im6.1"
ALTERNATIVE_LINK_NAME[compare.1] = "${mandir}/man1/compare.1"
ALTERNATIVE_TARGET[compare.1] = "${mandir}/man1/compare.im6.1"
ALTERNATIVE_LINK_NAME[composite.1] = "${mandir}/man1/composite.1"
ALTERNATIVE_TARGET[composite.1] = "${mandir}/man1/composite.im6.1"
ALTERNATIVE_LINK_NAME[conjure.1] = "${mandir}/man1/conjure.1"
ALTERNATIVE_TARGET[conjure.1] = "${mandir}/man1/conjure.im6.1"
ALTERNATIVE_LINK_NAME[convert.1] = "${mandir}/man1/convert.1"
ALTERNATIVE_TARGET[convert.1] = "${mandir}/man1/convert.im6.1"
ALTERNATIVE_LINK_NAME[display.1] = "${mandir}/man1/display.1"
ALTERNATIVE_TARGET[display.1] = "${mandir}/man1/display.im6.1"
ALTERNATIVE_LINK_NAME[identify.1] = "${mandir}/man1/identify.1"
ALTERNATIVE_TARGET[identify.1] = "${mandir}/man1/identify.im6.1"
ALTERNATIVE_LINK_NAME[import.1] = "${mandir}/man1/import.1"
ALTERNATIVE_TARGET[import.1] = "${mandir}/man1/import.im6.1"
ALTERNATIVE_LINK_NAME[mogrify.1] = "${mandir}/man1/mogrify.1"
ALTERNATIVE_TARGET[mogrify.1] = "${mandir}/man1/mogrify.im6.1"
ALTERNATIVE_LINK_NAME[montage.1] = "${mandir}/man1/montage.1"
ALTERNATIVE_TARGET[montage.1] = "${mandir}/man1/montage.im6.1"
ALTERNATIVE_LINK_NAME[stream.1] = "${mandir}/man1/stream.1"
ALTERNATIVE_TARGET[stream.1] = "${mandir}/man1/stream.im6.1"
