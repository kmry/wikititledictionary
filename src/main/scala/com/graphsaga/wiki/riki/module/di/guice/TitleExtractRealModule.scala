package com.graphsaga.wiki.riki.module.di.guice

import com.google.inject._
import com.graphsaga.wiki.peripheral.repo.{TitleInputRepository, TitleInputRepositoryImplMock}

class TitleExtractRealModule extends AbstractModule {
  override protected def configure(): Unit = {
    bind(classOf[TitleInputRepository]).to(classOf[TitleInputRepositoryImplMock])
  }
}
