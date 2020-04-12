package com.graphsaga.wiki.service

import com.graphsaga.wiki.domain.classifier.GyoOfJapanese
import com.graphsaga.wiki.repo.TitleInputRepository
import com.graphsaga.wiki.repo.input.TitleInput

object HiraganaService {
  private def isHiraganaName(str:String) = str.matches("""/^[ぁ-ん]+$/""")
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
      println("ひらがなを含むタイトルは見つかりませんでした。")
      return
    }

    hiraganatitleSeq.foreach{t =>
      println(s"そのうち、ひらがなを含むタイトルです : ${t.title}")
    }
  }

}
/**********************************
 * form用正規表現判定/備忘
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
 *Scala: 正規表現でマッチするかどうか調べる方法
 * https://qiita.com/suin/items/63703ad9fd538748ee46
 **********************************
 */
