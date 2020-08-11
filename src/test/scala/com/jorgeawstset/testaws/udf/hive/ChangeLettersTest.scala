package com.jorgeawstset.testaws.udf.hive

import org.apache.hadoop.hive.ql.udf.generic.GenericUDF
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory
import org.scalatest.FlatSpec
import org.apache.hadoop.io.Text
import org.junit.{Assert, Test}

class ChangeLettersTest extends FlatSpec {
  val changeLettersUDF = new ChangeLetters()
  val stringOI = PrimitiveObjectInspectorFactory.javaStringObjectInspector
  val objIO = changeLettersUDF.initialize(Array[ObjectInspector](stringOI))

  @Test
  def testChangeLettersSingleChar(): Unit = {
    val longStringinput = new Text("T")
    val expected = "U"
    val output: String = changeLettersUDF.evaluate(Array[GenericUDF.DeferredObject]( new GenericUDF.DeferredJavaObject(longStringinput))).toString()
    Assert.assertEquals("Output for one Char String not as expected",expected,output)
  }
  @Test
  def testChangeLettersEmptyString(): Unit = {
    val longStringinput = new Text("")
    val expected = ""
    val output: String = changeLettersUDF.evaluate(Array[GenericUDF.DeferredObject]( new GenericUDF.DeferredJavaObject(longStringinput))).toString()
    Assert.assertEquals("Output for empty String not as expected",expected,output)
  }
  @Test
  def testChangeLettersLongString(): Unit = {
    val longStringinput = new Text("ThisText")
    val expected = "UijtUfyu"
    val output: String = changeLettersUDF.evaluate(Array[GenericUDF.DeferredObject]( new GenericUDF.DeferredJavaObject(longStringinput))).toString()
    Assert.assertEquals("Output for long String not as expected",expected,output)


  }
}
