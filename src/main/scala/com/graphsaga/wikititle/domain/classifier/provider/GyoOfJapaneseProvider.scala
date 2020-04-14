package com.graphsaga.wikititle.domain.classifier.provider

import java.lang.reflect.Method

import com.graphsaga.wikititle.domain.classifier.{A, GyoOfJapanese, Ka, Na, Sa, Ta}

object GyoOfJapaneseProvider{
  /*
   * Javaで実行中のクラス名・メソッド名を取得する方法
   * https://qiita.com/munieru_jp/items/02533ebe5c822e6e29bb
   */
  private def printMethodName(method:Method) = {
    println ("-------------------------------------------------")
    println(s"『${method.getName()}』を含むタイトルを対象にします。")
  }

  def あ行 : GyoOfJapanese= {
    printMethodName(new Object(){}.getClass().getEnclosingMethod())
    A
  }
  def か行 : GyoOfJapanese= {
    printMethodName(new Object(){}.getClass().getEnclosingMethod())
    Ka
  }
  def さ行 : GyoOfJapanese= {
    printMethodName(new Object(){}.getClass().getEnclosingMethod())
    Sa
  }
  def た行 : GyoOfJapanese= {
    printMethodName(new Object(){}.getClass().getEnclosingMethod())
    Ta
  }
  def な行 : GyoOfJapanese= {
    printMethodName(new Object(){}.getClass().getEnclosingMethod())
    Na
  }

}

object GyoOfIrohaniProvider {
  // memo todo いろはにほへと　への対応
}