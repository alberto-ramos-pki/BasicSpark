package com.perkin.scala
import math._
object mid_x {
  //mid.x<-input.data[which(abs(y-mid.y)==min((abs(y-mid.y)))),"x"]

  def create_mask_mid_x(ys: Array[Double], mid_y: Double): Array[Boolean] = {

    var left_mask = ys.map( _ - mid_y)
    left_mask = left_mask.map(abs(_))
    val min_left_mask: Double = left_mask.min
    return left_mask.map(_ == min_left_mask )

  }

  def mid_x_determination(xs: Array[Double], ys: Array[Double], mid_y: Double): Double = {

    val mid_x: Array[Double] = xs.zip(create_mask_mid_x(ys, mid_y)).collect{ case (v, true) => v }
    return mid_x(0)
  }

  def main(args: Array[String]): Unit = {
    val xs = Array(1.0, 2.0, 3.0)
    val ys = Array(2.0, 4.0, 6.0)
    val mid_y = 1.0
    val mid_x = mid_x_determination(xs, ys, mid_y)
    println(mid_x)


  }
}
