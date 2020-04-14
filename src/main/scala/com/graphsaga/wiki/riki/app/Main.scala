/*
 * forked from bigwheel/scala-di-library-comparison
 */

package com.graphsaga.wiki.riki.app

import com.graphsaga.wiki.riki.module.runner.TitleExtractRunners

object Main {
  import TitleExtractRunners._
  import com.graphsaga.wiki.domain.classifier.provider.GyoOfJapaneseProvider._

  def main(args: Array[String]): Unit = {
    PureRun(あ行).run
    WireRun(か行).run
    WireRun(さ行).run
    WireRun(た行).run

  }
}
