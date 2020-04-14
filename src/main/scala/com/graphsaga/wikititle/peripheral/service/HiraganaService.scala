package com.graphsaga.wikititle.peripheral.service

import com.graphsaga.wikititle.domain.classifier.GyoOfJapanese
import com.graphsaga.wikititle.peripheral.repo.TitleInputRepository
import com.graphsaga.wikititle.peripheral.repo.input.TitleInput

object HiraganaService {
  val MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$"
  val MATCH_HIRAGANA = "^[\\u3040-\\u309F]+$"
  private def isHiraganaName(str:String) = str.matches(MATCH_HIRAGANA)
  private def getAllTitleString (seq:Seq[TitleInput]): String =
    seq.map{t => t.title}.mkString(", ")

  def printHiraganaNameOnly (titleInputRepository: TitleInputRepository, GyoOfJapanese: GyoOfJapanese): Unit={
    val titleSeq = titleInputRepository.getTitleSeqIn(GyoOfJapanese)
    if (titleSeq.isEmpty) {
      println("タイトルは０件でした。")
      return
    }
    println("見つかったタイトルは:"+ getAllTitleString(titleSeq))
    val hiraganatitleSeq = titleSeq.filter (t => isHiraganaName(t.title))
    if (hiraganatitleSeq.isEmpty) {
      println("『ひらがな』のみを含むタイトルは見つかりませんでした。")
      return
    }

    hiraganatitleSeq.foreach{t =>t.show}
  }

}
/**********************************
 * form用正規表現判定/備忘 java/scalaでは工夫が必要？
 * https://qiita.com/fubarworld2/items/9da655df4d6d69750c06
 **********************************
全角ひらがな                    /^[ぁ-ん]+$/
全角カタカナ                    /^([ァ-ン]|ー)+$/
全角ひらがな、カタカナ             /^[ぁ-んァ-ン]+$/
半角カナ                      /^[ｧ-ﾝﾞﾟ]+$/
漢字                          /^[一-龥]+$/
全角ひらがな、漢字               /^[一-龥ぁ-ん]/
全角ひらがな、全角カタカナ、漢字      /^[ぁ-んァ-ン一-龥]/

 **********************************
 * Javaで入力チェックを正規表現で行う
 **********************************

 「ASCII文字」のみ  val MATCH_ASCII = "^[\\u0020-\\u007E]+$";
「英字」のみ        val MATCH_ALPHA = "^[a-zA-Z]+$";
「数字」のみ        val MATCH_NUMBER = "^[0-9]+$";
「ひらがな」のみ     val MATCH_HIRAGANA = "^[\\u3040-\\u309F]+$";
「カタカナ」のみ     val MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";
「半カタカナ」のみ    val MATCH_HANKANA = "^[\\uFF65-\\uFF9F]+$";
「全角文字」のみ      val MATCH_ZENKAKU = "^[\\u3040-\\u30FF]+$";
 **********************************
 *Scala: 正規表現でマッチするかどうか調べる方法
 * https://qiita.com/suin/items/63703ad9fd538748ee46
 **********************************
 */
