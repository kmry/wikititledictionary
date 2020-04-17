package com.graphsaga.wikititle.riki.settings.lang

sealed abstract class LanguageSupported(val unsupportedMessage: String)

case object Japanese extends LanguageSupported("ワタシ、日本語しゃべれないよ")
case object English  extends LanguageSupported("ノー、イングリッシュ、センキュー")
case object Italian  extends LanguageSupported("わたくし、イタリア語はパスタしか知らないのかしら")
