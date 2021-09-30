val arr = Array("A", "B", "C")
val mask = Array(true,false,true)

arr.zip(mask).collect { case (v, true) => v }