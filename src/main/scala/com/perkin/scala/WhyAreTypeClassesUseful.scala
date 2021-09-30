package com.perkin.scala

object WhyAreTypeClassesUseful {


  trait Summable[T] {
    def sumElements(list: List[T]): T
  }

  implicit object IntSummable extends Summable[Int] {
    override def sumElements(list: List[Int]): Int = list.sum
  }

  implicit object StringSummable extends Summable[String] {
    override def sumElements(list: List[String]): String = list.mkString("")
  }

  def processMyList[T](list: List[T])(implicit summable: Summable[T]): T = {
    // sum up all the elments of a list
    // for integers sum = actual sum of the elements
    // for string concatenation of all elements
    // for other types eError
    summable.sumElements((list))
  }

  def main(args: Array[String]): Unit = {
    val intSum = processMyList( List(1,3,5) )(IntSummable)
    // val intSum = processMyList( List(1,3,5) ) Can be written without IntSummable
    val stringSum = processMyList( List("1","3","5") )
    val booleanSum = processMyList(List(1, 2, 4))(IntSummable)

  }

}
