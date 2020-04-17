package com.graphsaga.wikititle.domain.recommender

import java.util.UUID

import com.graphsaga.wikititle.riki.settings.lang.{English, Japanese, LanguageSupported}

trait MotherHacker {
  implicit val id:UUID
  implicit val lang:LanguageSupported
  def printTestMessage = MotherHacker.mutter(123)
}

object MotherHacker  {
  private val sectet_JP ="人妻ハッカーがちょっといけない秘密をつぶやきますわ。"
  private val sectet_EN ="I mutter a slightly bad secret..."
  private def xxx(x:Int) = x * x * x
  private def mutter(a: Int)(implicit id:UUID,lang:LanguageSupported): String =
    lang match{
      case Japanese => s"$sectet_JP 私、${a}を三乗すると${xxx(a)}になるを、英語で話すとちょっと厨二っぽくなりますの。"
      case English => s"$sectet_EN Answer of raising $a to the third power is ${xxx(a)}. Oh yeah!"
      case _ => lang.unsupportedMessage
    }

}
