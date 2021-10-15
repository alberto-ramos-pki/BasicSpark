package com.perkin.scala
import org.apache.commons.math3.util.FastMath._
object evaluate_parameters {

  def fun_y_from_x(x: Double, p1: Double, p2: Double,  p3: Double, p4: Double, p5: Double):Double = {
    p1 + (p2-p1) / pow(1 + pow(p3/x, p4), p5)
  }

  def reg_fun(xs: Array[Double], ys: Array[Double], parameters: (Double, Double, Double, Double, Double)): Double = {
    println("evaluate parameters")
    val p1 = parameters._1
    val p2 = parameters._2
    val p3 = parameters._3
    val p4 = parameters._4
    val p5 = parameters._5

    val y_param = xs.map(fun_y_from_x(_, p1, p2, p3, p4, p5))
    val reg = (ys, y_param).zipped.map(_ - _)
    val result = reg.map(pow(_,2)).sum
    return result
  }


  def main(args: Array[String]): Unit = {
    val xs = Array(1.0, 6.0)
    val ys = Array(2.0, 3.0)
    val parameters =Array( (1.0, 2.0, 3.0, 4.0, 5.0), (1.0, 2.0, 3.0, 2.0, 5.0))
    val resultados = for (param <- parameters) yield reg_fun(xs, ys, param)
    //println(regfun(xs, ys, parameters))
    resultados.foreach(println)
  }

}
