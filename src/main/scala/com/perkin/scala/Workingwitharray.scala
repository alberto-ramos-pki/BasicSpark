package com.perkin.scala
import Array._
import math._

object Workingwitharray {

  val array1 = new Array[Int](4)
  val array2 = new Array[Boolean](5)
  val array3 = Array(1,2,3,4)
  val list_with_range = List.range(0, 10)


  val array_to_map = Array(1.1, 4.4, 9.9)



  def main(args: Array[String]): Unit = {
    val result1 = for (x <- array1){
      println(x)
    }

    val result2 = for (i <- 0 to (array2.length-1)){
      println(array2(i))
    }

    val result3 = array3.foreach{ println }

    var sum_array = 0

    val result_sum = println( array3.foreach(sum_array += _) )

    val result_map = array_to_map.map(log(_)).foreach{ println }


  }

}
