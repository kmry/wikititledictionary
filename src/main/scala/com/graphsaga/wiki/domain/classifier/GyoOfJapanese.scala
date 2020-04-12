package com.graphsaga.wiki.domain.classifier

/**
 *　ア行、カ行、サ行、タ行、ナ行
 *
 * 参考　【Scala】列挙型を使おう
 * https://dev.classmethod.jp/articles/scala-algebra-data-type/
 */
sealed abstract class GyoOfJapanese(val index: Int)

case object A extends GyoOfJapanese(1)
case object Ka extends GyoOfJapanese(2)
case object Sa extends GyoOfJapanese(3)
case object Ta extends GyoOfJapanese(4)
case object Na extends GyoOfJapanese(5)
case object Ha extends GyoOfJapanese(6)
case object Ma extends GyoOfJapanese(7)
case object Ya extends GyoOfJapanese(8)
case object Ra extends GyoOfJapanese(9)
case object Wa extends GyoOfJapanese(10)

