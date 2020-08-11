package com.jorgeawstset.testaws

import org.scalatest.FlatSpec

class AppTest extends FlatSpec {
  "A String" should "have the same value" in {
    val cdena : String = new String("Hello World")
    assert( cdena === "Hello World")
  }
}