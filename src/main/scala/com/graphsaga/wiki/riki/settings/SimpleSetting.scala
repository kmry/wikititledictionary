package com.graphsaga.wiki.riki.settings

import org.apache.spark.sql.{SparkSession,Encoders}

object SimpleSetting {
  def getRedisSpark ={
    SparkSession
      .builder()
      .appName("redis-example")
      .master("local[*]")
      .config("spark.redis.host", "localhost")
      .config("spark.redis.port", "6379")
      .getOrCreate()
  }

}
