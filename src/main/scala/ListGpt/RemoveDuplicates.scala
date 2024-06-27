package ListGpt

object RemoveDuplicates extends  App {

  def removeDuplicates(nums: Array[Int]) = {
    nums.groupBy(x => x).flatMap(x => x._2.take(2)).toList

  }
  val s = Array(1,1,1,2,2,3)

  println(removeDuplicates((s)))

//  val s1 = List(2,1,1,2,2,3)
//  val (n1, n2) = s1.tail.partition(_ < s1.head)
//  println(n1, n2)


}
