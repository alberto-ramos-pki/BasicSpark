import play.api.libs.json.OptionHandlers.Default

var a: String = "a"
val list_a: List[Double] = List(1.0, 2.0)
val dict: Map[String, List[Double]] = Map(a -> list_a)
val lista_output = dict.get("b") getOrElse Nil



val a_val = 1.0
val b_val = 1.0
val c_val = 1.0
val d_val = None
val e_val = 1.0
val dict_params: Map[String, Any] = Map("a" -> a_val,
                                        "b" -> b_val,
                                        "c" -> c_val,
                                        "d" -> d_val,
                                        "e" -> e_val)


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







