package com.jorgeawstset.testaws

//import org.scalatest.FlatSpec
import org.scalatest.flatspec.AnyFlatSpec
class AppTest extends AnyFlatSpec {
  "A String" should "have the same value" in {
    val cdena : String = new String("Hello World")
    assert( cdena === "Hello World")
  }
}