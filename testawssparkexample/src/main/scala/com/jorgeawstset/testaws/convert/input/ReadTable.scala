package com.jorgeawstset.testaws.convert.input

import org.apache.spark.sql.{DataFrame, SparkSession}

object ReadTable {
  def read(spark: SparkSession, tableName: String): DataFrame = {
    spark.table(tableName)
  }
}
