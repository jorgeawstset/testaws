package com.jorgeawstset.testaws.convert.pipeline

import org.apache.spark.sql.SparkSession
import org.junit.{Assert, Test}
import org.scalatest.FlatSpec

class ConvertPipelineTest extends FlatSpec{

  val inputPath = "src/test/resources/csv/inputfile.csv"
  lazy val spark: SparkSession = SparkSession.builder()
    .master("local")
    .appName("Spark Session")
    .config(
      "spark.sql.shuffle.partitions",
      "1"
    ).getOrCreate()
  @Test
  def testConvertPipeline(): Unit = {
    val expected = "UijtUfyu"
    System.setProperty("hadoop.home.dir", "c:\\hadoop\\hadoop-2.6.5\\")
    import spark.implicits._
    val dataset = Seq((0, "ThisText"), (1, "A")).toDF("id", "Name")

    val pipelineDF = ConvertPipeline.run(dataset)
    val result = pipelineDF.filter("id = 0").take(1)(0).getAs[String](2)
    println("readdf 1")
//    val readdf = spark.read.csv(inputPath)
//    val readdf = spark.read.format("csv").option("inferSchema","true").option("header", "true").load(inputPath)
//    val dsds = spark.read.option("header","true").csv(inputPath)
    println("readdf 2")
    Assert.assertEquals("Output for a long String Spark UDF is not as expected", expected, result)
  }
}
