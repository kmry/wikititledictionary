package com.graphsaga.wiki.repo

import com.graphsaga.wiki.domain.classifier.{A, GyoOfJapanese, Sa}
import com.graphsaga.wiki.repo.input.TitleInput

class TitleInputRepositoryImplMock extends TitleInputRepository {
  //extracted from wikipedia dump : https://dumps.wikimedia.org/jawiki/
  private def getTitleSeqOfSa(): Seq[TitleInput] = {
    val dic = """
      |3049334:771:坂口いく
      |3049334:772:坂田靖子
      |3049334:773:桜沢エリカ
      |3049334:774:桜多吾作
      |3049334:774:桜多吾作
      |3049334:775:さくらももこ
      |3049334:776:佐江明
      |3049334:777:佐々木淳子
      |""".stripMargin.split("\\n")
    dic.flatMap {s => convertFromTitleString(s)}
  }

  override def getTitleSeqIn(GyoOfJapanese: GyoOfJapanese, limit: Int): Seq[TitleInput] = {
    GyoOfJapanese match {
      case A => Seq(TitleInput(-1,-1,"あんぱんまん"))
      case Sa => getTitleSeqOfSa()
      case _ => Seq.empty[TitleInput] // empty is `空`
    }

  }

}