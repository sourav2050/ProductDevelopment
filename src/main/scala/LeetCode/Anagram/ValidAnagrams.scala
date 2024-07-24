package LeetCode.Anagram

object ValidAnagrams extends App {

  def isAnagram(s: String, t: String): Boolean = {
    val sorted_s: String = s.mkString("").sorted
    val sorted_t: String = t.mkString("").sorted
    if (sorted_s == sorted_t) true else false
  }
  println("rat", "car") // false

}
