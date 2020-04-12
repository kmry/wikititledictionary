package com.graphsaga.wiki.job.module.di.wire

import com.graphsaga.wiki.repo.{TitleInputRepository, TitleInputRepositoryImplMock}
import com.graphsaga.wiki.service.TitleExtractService_macwire
import com.softwaremill.macwire._

class TitleExtractModule {
  lazy val TitleInputRepository: TitleInputRepository = wire[TitleInputRepositoryImplMock]
  lazy val TitleExtractService: TitleExtractService_macwire = wire[TitleExtractService_macwire]
}
