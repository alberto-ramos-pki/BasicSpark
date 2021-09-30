package com.perkin.scala

object if_expression {
  val meaning: Int = 2
  val ifExpression = if (meaning > 43 ) 1 else 99
  val chainedIf=
    if (meaning > 43 ) 1
    else if (meaning == 43 ) 1
    else 3


  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  def main(args: Array[String]): Unit = {
    println(myFunction(2, "3"))
    println(factorial(3))
  }

}
