package com.graphsaga.wiki.peripheral.service

import com.graphsaga.wiki.domain.classifier.GyoOfJapanese
import com.graphsaga.wiki.peripheral.repo.TitleInputRepository

class TitleExtractService_pure_scala(titleInputRepository: TitleInputRepository) {
  def printAllHiraganaName(GyoOfJapanese:GyoOfJapanese): Unit = {
    println("Pure Scalaにて :")
    HiraganaService.printHiraganaNameOnly(titleInputRepository, GyoOfJapanese)
  }
}

class TitleExtractService_macwire(titleInputRepository: TitleInputRepository) {
  def printAllHiraganaName(GyoOfJapanese:GyoOfJapanese): Unit = {
    println("Macwireにて :")
    HiraganaService.printHiraganaNameOnly(titleInputRepository, GyoOfJapanese)
  }
}