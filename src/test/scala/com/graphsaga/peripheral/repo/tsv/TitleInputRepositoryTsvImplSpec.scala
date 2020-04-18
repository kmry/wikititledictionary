package com.graphsaga.peripheral.repo.tsv

import com.graphsaga.util.WordCounterSpec
import com.graphsaga.wikititle.peripheral.repo.tsv.TitleInputRepositoryTsvImpl
import ut.base.UnitTestSpecBase
import ut.base.spark.SparkForUT

class TitleInputRepositoryTsvImplSpec  extends UnitTestSpecBase[TitleInputRepositoryTsvImpl] with SparkForUT{
  override val targetClass = classOf[TitleInputRepositoryTsvImpl]
  override lazy val testObjectName = ""

  feature(s"$testObjectName at ${_uuid}") {
    scenario(s"$testObjectName, concerning private method.") {
      Given(s"set arguments of ${targetClass.getSimpleName}.")
      val repo = new TitleInputRepositoryTsvImpl
      When(s"Define private method of ${targetClass.getSimpleName}")
      val ds = repo.getTitleInputDs(spark = spark)
      Then(s"Check result.")
       val ds2 = ds.filter(x => x.serial == 811901)

      ds2.show(20)
      print("ds2.count()",ds.count())
    }
  }
}

