package com.perkin.scala
import math._

object get_starting_parameters {

  trait quantile_function {
    def determine_quantile(array: Array[Double], quantile: Double): Double
  }


  case class statistical_x_y (val xs: Array[Double], val ys: Array[Double])  extends quantile_function {

    //method
    override def determine_quantile(array: Array[Double], quantile: Double): Double = {
      array.sortWith(_ < _).drop((array.length * quantile).toInt ).head}


    override def
    val min_y: Double = xs.min
    val min_x: Double = xs.min
    val max_x: Double = xs.max
    val max_y: Double = ys.max

    val mean_x: Double = xs.sum / xs.length
    val mid_y = (max_y - min_y) / 2.0 + min_y
    //val mid_x = xs.filter(   )
    val quantile_1x: Double = determine_quantile(xs, 0.1)
    val quantile_9x: Double = determine_quantile(xs, 0.9)
    val med_x = determine_quantile(xs, 0.5)

    }



  /*
  This object receives a xs and ys (array vector), and calculate the median
   */
  def main(args: Array[String]): Unit = {

    val xs = Array(1.0, 2.0, 3.0)
    val ys = Array(2.0, 4.0, 6.0)

    val result1 = new statistical_x_y (xs, ys)
    println("Quantile 10")
    println(result1.quantile_1x)

    println("Quantile 90")
    println(result1.quantile_9x)

  }


}
