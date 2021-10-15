Array("ab","c", "d", "e").combinations(2).toList
Array(1, 2, 3).combinations(2).toList

val a = Array("a","b","c")
val b = Array("x","y")
for (a_ <- a; b_ <- b) yield (a_, b_)


val k = Array(1,2,7)
val q = Array(0,3)
val c = Array(5,6)

val grid = for (k_ <- k; q_ <- q; c_ <-c) yield (k_, q_, c_)

grid(0)
grid(1)

