package LeetCode.PatternMatching

object SortedList extends App {

  val ll = List(4,5,2,7,9,3,2)

//  sort the list in descending order
  def mergeSort(ls: List[Int], rs: List[Int]): List[Int]  = {
    println(ls,rs)
    (ls, rs) match {
      case (_, Nil) => ls
      case(Nil, _) => rs
      case(lh::lt,rh::rt) => if (lh < rh) lh :: mergeSort(lt, rs) else rh :: mergeSort(ls, rt)
    }
  }

  def merge(ll: List[Int]): List[Int] = {
    val n = ll.length
    val (ls, rs) = ll.splitAt(n/2)
    println(ls, rs)
    if (n <= 1) ll
    else {
      mergeSort(merge(ls), merge(rs))
    }

  }

 println(merge(ll))


}
