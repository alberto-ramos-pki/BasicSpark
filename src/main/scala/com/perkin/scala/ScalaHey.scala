package com.perkin.scala
import org.apache.spark.{SparkConf, SparkContext}
import breeze.linalg.{DenseVector}


object ScalaHey {
  def main(args: Array[String]) : Unit  = {

    println("Spark Basics with Scala ")
    val x = DenseVector.zeros[Double](5)
    println(x)
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Basics")

    val sc = new SparkContext(conf)

    val rddobject = sc.makeRDD(Array(1,2,3))

    rddobject.collect().foreach(println)


  }

}
