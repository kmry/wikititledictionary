package com.graphsaga.wikititle.riki.module.di.wire

import com.graphsaga.wikititle.peripheral.repo.tsv.TitleInputRepositoryTsvImpl
import com.graphsaga.wikititle.peripheral.repo.{TitleInputRepository, TitleInputRepositoryImplMock}
import com.graphsaga.wikititle.peripheral.service.TitleExtractService_macwire
import com.softwaremill.macwire._

class TitleExtractModule {
  lazy val TitleInputRepository: TitleInputRepository = wire[TitleInputRepositoryTsvImpl]
  lazy val TitleExtractService: TitleExtractService_macwire = wire[TitleExtractService_macwire]
}
