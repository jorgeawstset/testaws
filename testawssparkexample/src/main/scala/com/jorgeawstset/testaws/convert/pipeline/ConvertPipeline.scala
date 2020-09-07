package com.jorgeawstset.testaws.convert.pipeline

import com.jorgeawstset.testaws.convert.output.WriteS3
import com.jorgeawstset.testaws.udf.spark.ChangeLetters
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions.sha2
import org.apache.spark.sql.{DataFrame, SparkSession}

object ConvertPipeline {

  def run(inputDF:DataFrame): DataFrame={
    println("+++ run" + inputDF)
    inputDF.show()
    val dd = inputDF.
      withColumn("Namechanged", ChangeLetters.changeLetters(col("Name"))).
      withColumn("Namesha512", sha2(col("Name"),512))
    dd.show()
    dd
  }
}
