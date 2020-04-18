package com.graphsaga.util

import com.graphsaga.util.spark.WordCounter
import ut.base.UnitTestSpecBase
import ut.base.spark.SparkForUT
class WordCounterSpec extends UnitTestSpecBase[WordCounterSpec] with SparkForUT{
  override val targetClass = classOf[WordCounterSpec]
  override lazy val testObjectName = ""

  feature(s"$testObjectName at ${_uuid}") {
    scenario(s"$testObjectName, concerning private method.") {
      Given(s"set arguments of ${targetClass.getSimpleName}.")
      //WordCounter.countLicenceTxt
      When(s"Define private method of ${targetClass.getSimpleName}")
      Then(s"Check result.")
    }
  }
}
