package com.graphsaga.wikititle.peripheral.repo.tsv

import com.graphsaga.wikititle.domain.classifier.GyoOfJapanese
import com.graphsaga.wikititle.peripheral.repo.TitleInputRepository
import com.graphsaga.wikititle.peripheral.repo.input.TitleInput

class TitleInputRepositoryTsvImpl extends TitleInputRepository {

  import org.apache.spark.sql.Encoders
  import org.apache.spark.sql.SparkSession

  //todo extracted from wikipedia dump : https://dumps.wikimedia.org/jawiki/
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
                |""".stripMargin.linesIterator.toSeq

    dic.flatMap {s => convertFromTitleString(s)}
  }
  def getTitleSeqIn(GyoOfJapanese:GyoOfJapanese, limit:Int = -1): Seq[TitleInput] = getTitleSeqOfSa()

  def getTitleInputDs(implicit spark: SparkSession) = {
    import spark.implicits._

    val schema = Encoders.product[TitleInput].schema
    val fn = """/mnt/c/Users/kmr_r/massCode/wiki_jp_all/jawiki-20200401-pages-articles.tsv"""
    //vファイルを読み込む場合は、フィールドセパレーターをタブ文字にしてcsv読み込み
    spark.read.schema(schema).option("sep", "\t").csv(fn).as[TitleInput]
  }
}
