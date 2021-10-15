package com.perkin.scala
import org.apache.commons.math3.util.FastMath._
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
import org.apache.commons.math3.stat.descriptive.rank.Percentile


object Get_starting_parameters {


  trait quantile_function {
    //determine the quantile of an array
    def determine_quantile(array: Array[Double], quantile: Double): Double
  }


  case class Statistical_parameters (val xs: Array[Double], val ys: Array[Double]) extends quantile_function{

    //method
    
    override def determine_quantile(array: Array[Double], quantile: Double): Double= {
        //Perform the calculation of the approx quantile = Double between [0, 1]
        // array.sortWith(_ < _).drop(( array.length * quantile).toInt ).head
      val stats = new DescriptiveStatistics
      array.foreach(stats.addValue(_))
      return stats.getPercentile(quantile)
    }
      
    
    

    private def create_mask_mid_x(mid_y: Double): Array[Boolean] = {
      //create a mask for x determined from y column and mid_y: this mask corresponds with
      //which(abs(y-mid.y)==min((abs(y-mid.y))))

      var left_mask = ys.map( _ - mid_y)
      left_mask = left_mask.map(abs(_))
      val min_left_mask: Double = left_mask.min
      return left_mask.map(_ == min_left_mask )

    }

    private def mid_x_determination(): Double = {
      //this is for implement the equation in R mid.x: mid.x<-input.data[which(abs(y-mid.y)==min((abs(y-mid.y)))),"x"]
      val mid_x: Array[Double] = xs.zip(create_mask_mid_x(mid_y)).collect{ case (v, true) => v }
      return mid_x(0)
    }

    lazy val min_y: Double = ys.min
    lazy val max_y: Double = ys.max
    lazy val min_x: Double = xs.min
    lazy val max_x: Double = xs.max
    lazy val mean_x: Double = xs.sum / xs.length
    lazy val mid_y = (max_y - min_y) / 2.0 + min_y
    lazy val mid_x = mid_x_determination
    lazy val quantile_1x: Double = determine_quantile(xs, 0.1)
    lazy val quantile_9x: Double = determine_quantile(xs, 0.9)
    lazy val med_x = determine_quantile(xs, 0.5)

    }


  class Create_grid_5_params(var x: Array[Double], var y: Array[Double], dict_params:Map[String, Double])
    extends Statistical_parameters(x, y) {
    //Create a grid with all the possible combinations of the parameters



    val a: Array[Double] = dict_params.get("a") getOrElse None match {
      case i: Double => Array(i)
      case None => Array(min_y, -min_y, -max_y)
    }

    val b: Array[Double] = dict_params.get("b") getOrElse None match {
      case i: Double => Array(i)
      case None => Array(max_y)
    }

    val c: Array[Double] = dict_params.get("c") getOrElse None match {
      case i: Double => Array(i)
      case None => Array(quantile_1x, mid_x, med_x, quantile_9x)
    }

    val d: Array[Double] = dict_params.get("d") getOrElse None match {
      case i: Double => Array(i)
      case None => Array(-2.5, -1.0, 0.0, 1.0, 2.5)
    }

    val e: Array[Double] = dict_params.get("e") getOrElse None match {
      case i: Double => Array(i)
      case None =>  Array(1)
    }

    //create a grid with all combinations from arrays with a for compression
    val grid_from_parameters = for (a_ <- a; b_ <- b; c_ <-c; d_ <-d; e_ <-e) yield (a_, b_, c_, d_, e_)
  }

  class Evaluate_parameters(var x_axis: Array[Double], var y_axis: Array[Double], start_list: Map[String, Double] )
    extends Create_grid_5_params(x_axis, y_axis, start_list){

    private def fun_y_from_x(x: Double, p1: Double, p2: Double,  p3: Double, p4: Double, p5: Double):Double = {
      p1 + (p2-p1) / pow(1 + pow(p3/x, p4), p5)
    }

    private def reg_fun(xs: Array[Double], ys: Array[Double], parameters: (Double, Double, Double, Double, Double)): Double = {
      //println("evaluate parameters")
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


    val evaluations = for (param <- grid_from_parameters) yield reg_fun(xs, ys, param)
  }




  def main(args: Array[String]): Unit = {

    //val xs = List.range(1, 200).map(x => x.toDouble).toArray//Array(1.0, 2.0, 3.0)
    //val ys = xs.map(2*_)
    val xs = Array(1.0, 2.0, 3.0)
    val ys = Array(2.0, 4.0, 6.0)

    //val stats = new DescriptiveStatistics
    //val array_test =List.range(1, 100).map(x => x.toDouble).toArray
    //xs.foreach(stats.addValue(_))
    //println("Array test percentil")
    //println(stats.getPercentile(10))

    //println("...")

/*
    val result1 = new Statistical_parameters (xs, ys)
    println("Quantile 10")
    println(result1.quantile_1x)

    println("Quantile 90")
    println(result1.quantile_9x)

    println("mid_y")
    println(result1.mid_y)

    println("mid_X")
    println(result1.mid_x)

    println("grid")

 */
   /* val grid = new Create_grid_5_params(xs, ys)
    grid.a.foreach(println)
    grid.grid_from_parameters.foreach(println)

    */
    val a_val: Double = 48.0
    val b_val: Double = 1.0
    val c_val: Double = 1.0
    val d_val: Double = 35.0
    val e_val: Double = 1.0
    val start_list: Map[String, Double] = Map("a" -> a_val,
                                              "b" -> b_val,
                                              "c" -> c_val,
                                              "d" -> d_val,
                                              "e" -> e_val)
    val eval_params = new Evaluate_parameters(xs, ys, start_list)
    //eval_params.evaluations.foreach(println)
    //println(s"min value")
    //println(eval_params.evaluations.min)
    //val masking_min =  eval_params.evaluations.map(_ == eval_params.evaluations.min)
    //println("mask")
    //masking_min.foreach(println)

    //val optimal_params = eval_params.grid_from_parameters.zip(masking_min).collect{ case(v, true) => v}
    //eval_params.a.foreach(println)

/*
    println(eval_params.mid_y)
    println("quantile 1x")
    println(eval_params.quantile_1x)
    val grid = eval_params.grid_from_parameters
    grid.foreach(println)

 */
    val optimal_params = eval_params.grid_from_parameters.
                    zip(eval_params.evaluations.map(_ == eval_params.evaluations.min)).
                    collect{ case(v, true) => v}


    println("optimal params")
    println(optimal_params(0))
    //optimal_params.foreach(println)
    //xs.zip(create_mask_mid_x(mid_y)).collect{ case (v, true) => v }

  }


}
