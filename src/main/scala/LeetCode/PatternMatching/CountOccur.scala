package LeetCode.PatternMatching

import scala.collection.mutable.ListBuffer

object CountOccur extends App {

  val input = "AAABBCCA"
  val output = "A3B2C2A1"
  var res = ""
  var count = 0
  var left = 0
  var right = 0

  def countOccurance(s: String): String = {
    for (i <- s.indices) {
      while(i >= right) {
        val char = s(i)
        while (right <= s.length - 1 && char == s(right)) {
          count += 1
          right += 1

        }
        res = res.concat(char + count.toString)

        count = 0
      }
    }
    res

  }

  def getMaxrepeated(l: List[Int]): ListBuffer[Int] = {
    val map = l.groupBy(x => x).map(x => (x._1, x._2.length))
    val values = l.groupBy(x => x).map(x => (x._1, x._2.length)).values.toList
    val maxLength = values.max
    val listBuffer = scala.collection.mutable.ListBuffer[Int]()
    map.map(x => if (x._2 == maxLength) listBuffer += x._1)
    listBuffer

  }




  println(countOccurance(input))
  println(getMaxrepeated(List(1,1,1,1,1,2,2,2,3,3,4,4,4,4,4)))

}
