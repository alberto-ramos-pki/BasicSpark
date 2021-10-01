package com.perkin.scala
import math._

object masking_array {
  def mask_array_ys(ys: Array[Double], mid_y: Double): Array[Boolean] = {

    //mid.x<-input.data[which(abs(y-mid.y)==min((abs(y-mid.y)))),"x"]
    val left = ys.map( _ - mid_y)
    val right = left.min
    val result = left.map(_ == right)
    return result
  }


  def main(args: Array[String]): Unit = {
    val ys = Array(1.0, 2.0, 3.0)
    val mask = mask_array_ys(ys, 2.0)
    println('H')
    //val maskedlist: Array[Double] = ys.zip(mask).collect{ case (v, true) => v }
    //mask.foreach{maskedlist}
  }

}
//abs(y-mid.y)==min((abs(y-mid.y)))