package com.jorgeawstset.testaws.convert.output

import org.apache.spark.sql.DataFrame

object WriteS3 {
  def saveCSV(dataFrame: DataFrame,pathOutput: String): Unit = {
    dataFrame.write.csv(pathOutput)
  }

}
