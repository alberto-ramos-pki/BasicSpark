def sum(is: List[Int]): Int = {

    // `loop` i our tail recursive function, keeping a running sum
    // in `acc`
    def loop(cur: List[Int], acc: Int): Int = cur match {
      case k :: m => loop(m, acc + k) //head and tail
      case _      => acc
    }

    loop(is, 0)
}
sum(List.range(1, 10))


Array(1,3,4).sum