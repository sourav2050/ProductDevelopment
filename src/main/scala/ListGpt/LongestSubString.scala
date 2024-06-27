package scala.ListGpt

object LongestSubString extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    var maxLength = 0
    var start = 0
    val indexMap = scala.collection.mutable.Map[Char, Int]()
    for (end <- s.indices) {
      val char = s(end)
      if (indexMap.contains(char) && indexMap(char) > start) {
        start = indexMap(char) + 1
      }
      indexMap(char) = end
      maxLength = math.max(maxLength, end - start + 1)

    }
    maxLength
  }
  println(lengthOfLongestSubstring("abcabcbb"))

}
