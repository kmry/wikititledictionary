package com.graphsaga.wiki.service

import com.google.inject.Inject
import com.graphsaga.wiki.domain.classifier.GyoOfJapanese
import com.graphsaga.wiki.repo.TitleInputRepository

class TitleExtractService_pure_scala(titleInputRepository: TitleInputRepository) {
  def printAllHiraganaName(GyoOfJapanese:GyoOfJapanese): Unit = {
    println("Pure Scalaにて :")
    HiraganaService.printHiraganaNameOnly(titleInputRepository, GyoOfJapanese)
  }
}

class TitleExtractService_google_guice @Inject() (titleInputRepository: TitleInputRepository) {
  def printAllHiraganaName(GyoOfJapanese:GyoOfJapanese): Unit = {
    println("Google Guiceにて :")
    HiraganaService.printHiraganaNameOnly(titleInputRepository, GyoOfJapanese)
  }
}

class TitleExtractService_airframe(titleInputRepository: TitleInputRepository) {
  def printAllHiraganaName(GyoOfJapanese:GyoOfJapanese): Unit = {
    println("Airframeにて :")
    HiraganaService.printHiraganaNameOnly(titleInputRepository, GyoOfJapanese)
  }
}

class TitleExtractService_macwire(titleInputRepository: TitleInputRepository) {
  def printAllHiraganaName(GyoOfJapanese:GyoOfJapanese): Unit = {
    println("Macwireにて :")
    HiraganaService.printHiraganaNameOnly(titleInputRepository, GyoOfJapanese)
  }
}