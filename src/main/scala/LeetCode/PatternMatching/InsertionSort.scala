package LeetCode.PatternMatching

object InsertionSort extends App {

  val ll = List(3,4,2,9,5,1) // sort in ascending order
  def insertSort(ls: List[Int]): List[Int] = {
    def srtList(x: Int, sortList: List[Int]): List[Int] = {
      sortList match {
        case Nil => List(x)
        case head :: tail =>
          if (x <= head) {
            println(x :: sortList)
            x :: sortList
          }
          else {
            println(head :: srtList(x, tail))
            head :: srtList(x, tail)
          }
      }
    }
    ls match {
      case Nil => Nil
      case head :: tail =>
        println(head, tail)
        srtList(head, insertSort(tail))
    }
  }

  println(insertSort(ll))

}
