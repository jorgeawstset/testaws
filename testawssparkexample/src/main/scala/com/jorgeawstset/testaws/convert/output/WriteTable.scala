package com.jorgeawstset.testaws.convert.output

import org.apache.spark.sql.DataFrame

object WriteTable {
  def save(dataFrame: DataFrame,tableOutput: String): Unit = {
    dataFrame.write.saveAsTable(tableOutput)
  }
}
