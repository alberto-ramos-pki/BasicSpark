package com.perkin.scala
import org.apache.spark.{SparkConf, SparkContext}
object ScalaHey {
  def main(args: Array[String]) : Unit  = {

    val conf = new SparkConf()
    conf.setMaster("local")


  }

}
