require ruby.inc
PR = "${INC_PR}.0"

SRC_URI += "\
    file://ruby-2.1.4-always-use-i386.patch \
    file://ruby-2.1.0-Prevent-duplicated-paths-when-empty-version-string-i.patch \
    file://ruby-2.1.0-custom-rubygems-location.patch \
    file://ruby-1.9.3-mkmf-verbose.patch \
    file://ruby-1.9.3-install-cross.patch \
"

SRC_URI[md5sum] = "89b2f4a197621346f6724a3c35535b19"
SRC_URI[sha256sum] = "bf9952cdeb3a0c6a5a27745c9b4c0e5e264e92b669b2b08efb363f5156549204"

EXTRA_OECONF = "\
    --enable-wide-getaddrinfo \
    --with-rubygemsdir=${datadir}/rubygems \
    --disable-versioned-paths \
    --disable-rpath \
    --enable-shared \
"

EXTRA_OEMAKE = " \
    LIBRUBYARG='-lruby-static' \
"

do_install() {
    if [ ${PN} = "ruby" ]; then
        oe_runmake 'DESTDIR=${D}' install install-cross
    else
        oe_runmake 'DESTDIR=${D}' install
    fi
}

FILES_${PN} += "${datadir}/rubygems \
                ${datadir}/ri"

FILES_${PN}-dbg += "${libdir}/ruby/*/.debug \
                    ${libdir}/ruby/*/*/.debug \
                    ${libdir}/ruby/*/*/*/.debug \
                    ${libdir}/ruby/*/*/*/*/.debug"

BBCLASSEXTEND = "native"
