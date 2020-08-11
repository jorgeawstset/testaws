package com.jorgeawstset.testaws.udf.hive

import org.apache.hadoop.hive.ql.exec.UDFArgumentException
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF
import org.apache.hadoop.hive.serde2.objectinspector.{ObjectInspector, PrimitiveObjectInspector}
import org.apache.hadoop.hive.serde2.objectinspector.primitive.{PrimitiveObjectInspectorFactory, StringObjectInspector}
import org.apache.hadoop.io.Text

class ChangeLetters extends GenericUDF {

  private var objIns: StringObjectInspector = _

  override def getDisplayString(strings: Array[String]): String = "ChangeLetters"

  override def initialize(objectInspectors: Array[ObjectInspector]): ObjectInspector = {
    if (objectInspectors == null) throw new UDFArgumentException("the argument is null")
    if (objectInspectors.length != 1) throw new UDFArgumentException("Number of arguments should be one")
    if (!objectInspectors(0).isInstanceOf[StringObjectInspector] ) throw new UDFArgumentException("Argument should be a String")
    this.objIns = objectInspectors(0).asInstanceOf[StringObjectInspector]
    PrimitiveObjectInspectorFactory.javaStringObjectInspector
  }

  override def evaluate(deferredObjects: Array[GenericUDF.DeferredObject]): AnyRef = {
    if ( deferredObjects(0).get() == null ) return null
    val argument = this.objIns.getPrimitiveJavaObject(deferredObjects(0).get())
    new Text(argument.map(x => (x+1).toChar))

  }
}
