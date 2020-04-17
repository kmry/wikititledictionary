package com.graphsaga.wikititle.riki.job

import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}
import com.redislabs.provider.redis._
import org.apache.spark.{SparkConf, SparkContext}

class RedisSparkJob extends Sparkjob {
  val clicks = spark
    .readStream
    .format("redis")
    .option("stream.keys","clicks")
    .schema(StructType(Array(
      StructField("asset", StringType),
      StructField("cost", LongType)
    )))
    .load()


  val sc = new SparkContext(new SparkConf()
    .setMaster("local")
    .setAppName("myApp")
    // initial redis host - can be any node in cluster mode
    .set("spark.redis.host", "localhost")
    // initial redis port
    .set("spark.redis.port", "6379")
    // optional redis AUTH password
    .set("spark.redis.auth", "mypasswd")
  )
}
