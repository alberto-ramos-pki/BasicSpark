
import org.apache.commons.math3.util.FastMath._
val xs = Array(1.0, 2.0)
val ys = Array(3.0, 4.0)

val grid_1 = 3.0
val p1 = 1.0
val p2 = 2.0
lazy val evaluation_1 = xs.map(pow(_,p2)+p1)




val evaluation_2: Array[Double] = (xs, ys).zipped.map(_-_)
val evaluation_3 = evaluation_2.sum
val evaluation_4 = evaluation_1.sum

lazy val evaluation_5 = (ys, evaluation_1).zipped.map(_ - _)
val evaluation_6 = evaluation_5.map(pow(_,2)).sum