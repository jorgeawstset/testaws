package com.jorgeawstset.testaws.convert.input

import org.apache.spark.sql.{DataFrame, SparkSession}

object ReadS3 {
  def read(spark: SparkSession, pathInput: String): DataFrame = {
    spark.read.csv(pathInput)
  }
}
