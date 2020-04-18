package com.graphsaga.wikititle.riki.job

import com.graphsaga.wikititle.riki.settings.SimpleSetting
import org.apache.spark.sql.SparkSession

trait Sparkjob {
  lazy val spark: SparkSession = SimpleSetting.getKryoSpark

}
