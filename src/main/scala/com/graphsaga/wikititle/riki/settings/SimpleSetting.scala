package com.graphsaga.wikititle.riki.settings

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoders, SparkSession}

object SimpleSetting {
  def getRedisSpark :SparkSession={
    SparkSession
      .builder()
      .appName("redis-example")
      .master("local[*]")
      .config("spark.redis.host", "localhost")
      .config("spark.redis.port", "6379")
      .getOrCreate()
  }
  def getKryoSpark:SparkSession ={
    val conf = new SparkConf().setMaster("local[2]").setAppName("kryo-example")
    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    conf.set("spark.kryo.registrator", "example.registry.GoldKryoRegistrator")

    SparkSession.builder().master("local").
      config(conf).appName("kryo1").getOrCreate()

  }

}
