package com.graphsaga.wiki.riki.module.runner

import com.google.inject.Guice
import com.graphsaga.wiki.domain.classifier.GyoOfJapanese
import com.graphsaga.wiki.riki.module.di.guice.TitleExtractRealModule
import com.graphsaga.wiki.riki.module.di.wire.TitleExtractModule
import com.graphsaga.wiki.peripheral.repo.{TitleInputRepository, TitleInputRepositoryImplMock}
import com.graphsaga.wiki.peripheral.service.TitleExtractService_pure_scala

trait Runner {
  def run
}
object TitleExtractRunners {
  case class PureRun(x:GyoOfJapanese) extends Runner {
    // pure scala
    override def run =
      new TitleExtractService_pure_scala(new TitleInputRepositoryImplMock).printAllHiraganaName(x)
  }

  case class WireRun(x:GyoOfJapanese) extends Runner {
    // macwire
    // コードの参考ページ: https://github.com/adamw/macwire#macwire
    override def run =
      new TitleExtractModule().TitleExtractService.printAllHiraganaName(x)
  }
}
