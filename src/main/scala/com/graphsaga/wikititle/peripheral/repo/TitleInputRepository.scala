package com.graphsaga.wikititle.peripheral.repo

import com.graphsaga.wikititle.domain.classifier.GyoOfJapanese
import com.graphsaga.wikititle.peripheral.repo.input.TitleInput

trait TitleInputRepository {

  import com.graphsaga.util.StringUtils.StringImprovements

  /**
   * getTitleSeqInメソッド:
   * ア行、カ行、サ行、タ行、ナ行からはじまるwikipediaのタイトルを返します。
   * @param GyoOfJapanese　ア行、カ行、サ行、タ行、ナ行...を指定
   * @param limit: 0以上:返す件数、０未満: 全件(default)
   * @return wikipediaのタイトルのシーケンス(Seq)
   */
  def getTitleSeqIn(GyoOfJapanese:GyoOfJapanese, limit:Int = -1): Seq[TitleInput]

  protected def convertFromTitleString(ts:String):Option[TitleInput] ={
    val arr = ts.split(":")
    if (arr.size < 2) return None

    (arr(0).toIntOpt, arr(1).toIntOpt) match {
      case (Some(serial), Some(branch)) =>
        Some(TitleInput(serial,branch,arr(2)))
      case _ => None
    }
  }
}