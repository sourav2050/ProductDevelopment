package LeetCode.FoldLeft

object SubArraySum extends App {
  var sum = 0
  var left = 0
  var minLength = Int.MaxValue
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    val pairedNums = nums.zipWithIndex
    pairedNums.foldLeft(Int.MaxValue)((min, x) => {
      sum += x._1
      while(sum >= target) {
        minLength = Math.min(min, x._2 - left + 1)
        sum -= nums(left)
        left += 1
      }
      minLength
    })
    if (minLength == Int.MaxValue) 0 else minLength

  }

  val target = 7
  val nums = Array(2, 3, 1, 2, 4, 3)

  //  val target = 4
  //  val nums = Array(1,4,4)
  //  val target = 11
  //  val nums = Array(1,1,1,1,1,1,1,1)
  println(minSubArrayLen(target, nums))

}
