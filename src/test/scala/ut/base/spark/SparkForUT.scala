package ut.base.spark

import com.graphsaga.wikititle.riki.settings.SimpleSetting
import org.apache.spark.{SparkConf, SparkContext}

trait SparkForUT {
/*
  private val conf = new SparkConf().setAppName(this.getClass.toString)
  try {
    conf.get("spark.master")
  } catch {
    case e: NoSuchElementException => conf.setMaster("local[*]")
  }
  implicit lazy val sc = new SparkContext(conf)

 */
  implicit lazy val spark = SimpleSetting.getRedisSpark
}
