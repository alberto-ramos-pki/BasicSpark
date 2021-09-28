package com.perkin.scala
import scala.util.Random
object cases_matching {

def main(args: Array[String]) : Unit = {

  println("Matching")

  val x: Int = Random.nextInt(10)

  x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }
  println(x)

}
}
