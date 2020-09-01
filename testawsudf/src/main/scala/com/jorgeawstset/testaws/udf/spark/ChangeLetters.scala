package com.jorgeawstset.testaws.udf.spark

import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

object ChangeLetters extends java.io.Serializable{

  private def changeLettersUDF(input:String): Option[String] ={
    if ( null == input ) { return None}
    Some(input.map(x => ( x +1).toChar))
  }
  val changeLetters: UserDefinedFunction = udf[Option[String],String](changeLettersUDF)
}
