package com.graphsaga.wiki.job.module.di.guice

import com.google.inject._
import com.graphsaga.wiki.repo.{TitleInputRepository, TitleInputRepositoryImplMock}

class TitleExtractRealModule extends AbstractModule {
  override protected def configure(): Unit = {
    bind(classOf[TitleInputRepository]).to(classOf[TitleInputRepositoryImplMock])
  }
}
