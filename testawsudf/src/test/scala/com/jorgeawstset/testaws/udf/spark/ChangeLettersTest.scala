package com.jorgeawstset.testaws.udf.spark

import org.scalatest.FlatSpec
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.junit.{Assert, Test}

class ChangeLettersTest extends FlatSpec {
  lazy val spark: SparkSession = SparkSession.builder()
    .master("local")
    .appName("Spark Session")
    .config(
      "spark.sql.shuffle.partitions",
      "1"
    ).getOrCreate()


  @Test
  def testChangeLettersLongString(): Unit = {
    System.setProperty("hadoop.home.dir", "c:\\hadoop\\hadoop-2.6.5\\")
    import spark.implicits._
    val dataset = Seq((0, "ThisText"), (1, "A")).toDF("id", "text")
    val expected = "UijtUfyu"
    val ds2 = dataset.select(col("id"), col("text"), ChangeLetters.changeLetters(col("text")))
    val result = ds2.filter("id = 0").take(1)(0).getAs[String](2)
    Assert.assertEquals("Output for a long String Spark UDF is not as expected", expected, result)
  }
}
