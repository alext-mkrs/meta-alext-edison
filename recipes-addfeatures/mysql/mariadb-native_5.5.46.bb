require mariadb.inc
inherit native

PROVIDES += "mysql5-native"
DEPENDS = "ncurses-native zlib-native bison-native"

RDEPENDS_${PN} = ""
PACKAGES = ""
EXTRA_OEMAKE = ""

# added by AlexT - needed in combination with newer CMake in rel 3.0
OECMAKE_C_COMPILER = "`which gcc`"
OECMAKE_CXX_COMPILER = "`which g++`"

do_install() {
    oe_runmake 'DESTDIR=${D}' install

    install -d ${D}${bindir}
    install -m 0755 sql/gen_lex_hash ${D}${bindir}/
    install -m 0755 extra/comp_err ${D}${bindir}/
    install -m 0755 scripts/comp_sql ${D}${bindir}/
}

