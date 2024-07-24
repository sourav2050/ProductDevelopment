package LeetCode.Anagram
import scala.collection.mutable._

object FindAnagrams extends App {

  def findAnagrams(s: String, p: String): List[Int] = {
    var output = List.empty[Int]
    for (i <- 0 until s.length-p.length + 1) {
      val req = s.substring(i, i+p.length)
      if (p.sorted == req.sorted) {
        output = output :+ i
      }
    }
    output

  }

  def findAnagramsUsingFoldLeft(s: String, p: String): List[Int] = {
    val pSorted = p.sorted
    val pLength = p.length
    (0 until(s.length-p.length+1)).foldLeft(List.empty[Int]){(output, i) =>
      val req = s.substring(i , i + p.length)
      if (p.sorted == req.sorted) {
        output :+ i
      } else output
    }
  }

  def findAnagramsRecursion(s: String, p: String): List[Int] = {
    val pSorted = p.sorted
    val pLength = p.length

    @scala.annotation.tailrec
    def helper(i: Int, acc: List[Int]): List[Int] = {
      if (i > s.length - p.length) acc
      else {
        val req = s.substring(i, i + p.length)
        if (p.sorted == req.sorted)
          helper(i+1, acc :+ i)
        else
          helper(i +1 , acc)
      }
    }
    helper(0, List.empty[Int])
  }
  val s = "cbaebabacd"
  val p = "abc"
  println(findAnagrams(s, p))
  println(findAnagramsUsingFoldLeft(s, p))
  println(findAnagramsRecursion(s, p))

}

/*
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
 */
