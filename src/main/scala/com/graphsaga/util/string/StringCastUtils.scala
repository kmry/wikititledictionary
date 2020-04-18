package com.graphsaga.util.string

object StringCastUtils {
  /*
   *  Safely parsing Strings to numbers in Scala
   *  https://coderwall.com/p/lcxjzw/safely-parsing-strings-to-numbers-in-scala
   */
  implicit class StringImprovements(val s: String) {
    import scala.util.control.Exception._
    def toIntOpt = catching(classOf[NumberFormatException]) opt s.toInt
  }
}