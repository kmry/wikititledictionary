package com.graphsaga.wiki.riki.module.di.wire

import com.graphsaga.wiki.peripheral.repo.{TitleInputRepository, TitleInputRepositoryImplMock}
import com.graphsaga.wiki.peripheral.service.TitleExtractService_macwire
import com.softwaremill.macwire._

class TitleExtractModule {
  lazy val TitleInputRepository: TitleInputRepository = wire[TitleInputRepositoryImplMock]
  lazy val TitleExtractService: TitleExtractService_macwire = wire[TitleExtractService_macwire]
}
