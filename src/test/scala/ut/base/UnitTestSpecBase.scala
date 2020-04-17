package ut.base

import java.util.UUID

import org.scalatest.{Assertions, FeatureSpec, GivenWhenThen, Matchers, PrivateMethodTester}

abstract class UnitTestSpecBase[T] extends FeatureSpec
  with GivenWhenThen
  with Assertions
  with Matchers
  with PrivateMethodTester {
  val targetClass: Class[T]  //= classOf[T]
  lazy val testObjectName:String = s"Test of ${targetClass.getSimpleName}"
  val _uuid = uuidForTest
  private def uuidForTest = UUID.randomUUID()

  /** Usage:
  feature(s"$testObjectName at ${_uuid}") {
    scenario(s"$testObjectName, concerning private method.") {
      Given(s"set arguments of ${targetClass.getSimpleName}.")
      When(s"Define private method of ${targetClass.getSimpleName}")
      Then(s"Check result.")
    }
  }
  */

}
