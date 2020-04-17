package com.graphsaga.wikititle.domain.recommender

import com.graphsaga.wikititle.riki.settings.lang._
import ut.base.UnitTestSpecBase

class MotherHackerSpec extends  UnitTestSpecBase[MotherHacker]{
  override val targetClass = classOf[MotherHacker]
  override lazy val testObjectName = s"Test of ${targetClass.getSimpleName}"

  feature(s"$testObjectName at ${_uuid}") {
    scenario(s"$testObjectName, concerning private method.") {
      Given(s"set arguments of ${targetClass.getSimpleName}.")
      val _num = 226
      val langs:Seq[LanguageSupported] = Seq(Japanese,English,Italian)

      When(s"Define private method of ${targetClass.getSimpleName}")

      val mutter = PrivateMethod[String]('mutter)
      val XXX = PrivateMethod[Int]('xxx)
      val answer = MotherHacker invokePrivate (XXX(_num))

      Then(s"Check result.")
      langs.foreach {lang=>
        val result = MotherHacker invokePrivate (mutter(_num,_uuid,lang))
        assert (result contains answer.toString)
      }
    }

  }
}
