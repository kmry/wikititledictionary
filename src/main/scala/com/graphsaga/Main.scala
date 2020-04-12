/*
 * forked from bigwheel/scala-di-library-comparison
 */

package com.graphsaga

import com.graphsaga.wiki.job.module.runner.TitleExtractRunners

object Main {
  import TitleExtractRunners._
  import com.graphsaga.wiki.domain.classifier.provider.GyoOfJapaneseProvider._

  def main(args: Array[String]): Unit = {
    PureRun(あ行).run
    WireRun(か行).run
    GuiceRun(さ行).run
    AirRun(た行).run

  }
}
