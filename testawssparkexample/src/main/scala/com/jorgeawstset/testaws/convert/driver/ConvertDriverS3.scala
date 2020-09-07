package com.jorgeawstset.testaws.convert.driver

import com.jorgeawstset.testaws.convert.input.ReadS3
import com.jorgeawstset.testaws.convert.output.WriteS3
import com.jorgeawstset.testaws.convert.pipeline.ConvertPipeline
import com.jorgeawstset.testaws.udf.spark.ChangeLetters
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object ConvertDriverS3 {

  lazy val spark: SparkSession = SparkSession.builder()
    .master("local")
    .appName("Convert")
    .config(
      "spark.sql.shuffle.partitions",
      "1"
    ).getOrCreate()

  def main(args: Array[String]):Unit = {
    println("Inside ConvertDriver")
    val pathInput = args(0)
    val pathOutput = args(1)
    println("pathInput: " + pathInput)
    println("pathOutput: " + pathOutput)
    val inputDF = spark.read.csv(pathInput)
    val inDF = ReadS3.read(spark,pathInput)
    val outDF = ConvertPipeline.run(inputDF)
    WriteS3.saveCSV(outDF,pathOutput)
  }
}
