package LeetCode
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

object SubArraySum extends App {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    var min = Int.MaxValue
    println(min)
    var sum = 0
    var left = 0
    for (right <- nums.indices) {
      sum += nums(right)
      while (sum >= target) {
        min = Math.min(min, right - left + 1)
        sum -= nums(left)
        left += 1
      }
    }
    if (min == Int.MaxValue) 0 else min
  }
  val target = 7
  val nums = Array(2,3,1,2,4,3)

//  val target = 4
//  val nums = Array(1,4,4)
//  val target = 11
//  val nums = Array(1,1,1,1,1,1,1,1)
  println(minSubArrayLen(target, nums))

}
