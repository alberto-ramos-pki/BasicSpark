package com.perkin.scala

object SortList {
  def main(args: Array[String]): Unit = {


    def basicSort(list_input: List[Int]): List[Int] = {

      println("Sort list with list_input.sorted")
      list_input.sorted
    }

    def basicSortWithhigher(list_input: List[Int]): List[Int] =  {
        println("Sort list with list_input.sortWith(_ > _)")
        list_input.sortWith(_ > _)
    }

    def basicSortWithlower(list_input: List[Int]): List[Int] =  {
      println("Sort list with list_input.sortWith(_ < _)")
      list_input.sortWith(_ < _)
    }

    println("Creating list call a:")
    var list_initial: List[Int] = List(2, 3, 1)
    println(list_initial)

    println(basicSort(list_initial))

    println(basicSortWithhigher(list_initial))
    println(basicSortWithlower(list_initial))

  }
}
