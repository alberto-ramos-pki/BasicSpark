def sum(is: List[Int]): Int = {

    // `loop` i our tail recursive function, keeping a running sum
    // in `acc`
    def loop(cur: List[Int], acc: Int): Int = cur match {
      case h :: t => loop(t, acc + h)
      case _      => acc
    }

    loop(is, 0)
}
sum(List.range(1, 30000))