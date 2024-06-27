package scala.ListGpt

object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): Option[(Int, Int)] = {
    nums.zipWithIndex.foldLeft(Option.empty[(Int, Int)]){
      case(acc, (num, idx)) =>
        acc match {
          case None => nums.slice(idx + 1, nums.length).find(_ + num == target).map((_, num))
          case some => some
        }
    }


  }
  println(twoSum(Array(2,3,4,5), 9))

}
