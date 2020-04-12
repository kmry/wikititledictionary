package com.graphsaga.wiki.job.module.runner

import com.google.inject.Guice
import com.graphsaga.wiki.domain.classifier.GyoOfJapanese
import com.graphsaga.wiki.job.module.di.guice.TitleExtractRealModule
import com.graphsaga.wiki.job.module.di.wire.TitleExtractModule
import com.graphsaga.wiki.repo.{TitleInputRepository, TitleInputRepositoryImplMock}
import com.graphsaga.wiki.service.{TitleExtractService_airframe, TitleExtractService_google_guice, TitleExtractService_pure_scala}

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

  case class GuiceRun(x:GyoOfJapanese) extends Runner {
    // google guice
    // コードの参考ページ: https://qiita.com/saka1_p/items/45fdf1f736173fcf1c5a
    val injector = Guice.createInjector(new TitleExtractRealModule)

    override def run =
      injector.getInstance(classOf[TitleExtractService_google_guice]).printAllHiraganaName(x)
  }

  case class AirRun(x:GyoOfJapanese) extends Runner {
  // airframe
  // コードの参考ページ: https://wvlet.org/airframe/docs/index.html#constructor-injection

    import wvlet.airframe._

    val design = newDesign
      .bind[TitleInputRepository].toSingletonOf[TitleInputRepositoryImplMock]

    override def run =
      design.build[TitleExtractService_airframe] { TitleExtractService =>
        TitleExtractService.printAllHiraganaName(x)
      }
  }

}
