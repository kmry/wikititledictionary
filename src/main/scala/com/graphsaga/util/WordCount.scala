package com.graphsaga.util

import com.atilika.kuromoji.ipadic.Tokenizer
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object WordCounter {

  lazy val tokenizer: Tokenizer = new Tokenizer()

  def count(fullPathOfFilename:String)(implicit sc:SparkContext): Unit = {

    val textFile: RDD[String]= sc.textFile(fullPathOfFilename)
    val words = textFile.flatMap(line => line.split(" "))
    val wordCounts = words.map(word => (word, 1)).reduceByKey((a,b) => a+b)
    println("*****************")
    println("Count result: ",wordCounts.id, wordCounts.name)
    println("*****************")

  }
  def countLicenceTxt(implicit sc:SparkContext) = count("LICENCE.txt")
}