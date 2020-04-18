package com.graphsaga.util.tokenizer
  // Special thanks for:
  // https://qiita.com/takayuki_tk

import com.graphsaga.util.tokenizer.model.{Noun, Verb}
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.matchers._

class JapaneseTokenizerSpec extends FunSpec with Matchers {
  describe("JapaneseTokenizer") {
    it("should translate hiragana to katakana") {
      JapaneseTokenizer.toKatakana("あ") should be("ア")
      JapaneseTokenizer.toKatakana("愛") should be("アイ")
    }

    it("should translate hiragana which contains katakana to katakana") {
      JapaneseTokenizer.toKatakana("アイ愛あい") should be("アイアイアイ")
    }

    it("should tokenize document") {
      val tokens = JapaneseTokenizer.tokenize("家に帰る")
      tokens.size should be(3)
      tokens(0).value should be("家")
      tokens(0).kana should be("イエ")
      tokens(0).wordClass should be(Noun)

      tokens(2).value should be("帰る")
      tokens(2).wordClass should be(Verb)
    }

    it("should to hiragana") {
      JapaneseTokenizer.toHiragana("明日は晴れるかなぁ。") should be("あしたははれるかなぁ。")
      JapaneseTokenizer.toHiragana("今日の晩ご飯は湯豆腐") should be("きょうのばんごはんはゆどうふ")
    }

    it("should be latin") {
      JapaneseTokenizer.toLatin("日曜日") should be("nichiyoubi")
    }

    it("should translatee ー") {
      JapaneseTokenizer.toHiragana("スーパーマーケット") should be("すーぱーまーけっと")
    }

    it("should translatee ゔぁ") {
      JapaneseTokenizer.toHiragana("ヴァンパイア") should be("ゔぁんぱいあ")
      JapaneseTokenizer.toHiragana("ヴぁンパイア") should be("ゔぁんぱいあ")
      JapaneseTokenizer.toHiragana("ゔァンパイア") should be("ゔぁんぱいあ")
    }
  }
}
