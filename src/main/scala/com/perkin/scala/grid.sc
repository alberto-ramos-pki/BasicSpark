def create_grid(a: Array[Double], b: Array[Double]): Array[Double] = {
  val result = a ++ b
  return result
}

val a = Array(1.0, 2.0)
val b = Array(3.0, 4.0)

val c = create_grid(a, b)