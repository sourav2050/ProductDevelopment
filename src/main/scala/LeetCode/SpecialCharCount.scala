package LeetCode

object SpecialCharCount extends App {
  def numberOfSpecialChars(word: String): Int = {
    val len = word.distinct.length
    var res = 0
    val map= Map('a' -> 'A', 'b' -> 'B', 'c' -> 'C','d' -> 'D','e'-> 'E')
    if (len  == 0) 0
    else {
      val s: List[Char] = word.distinct.mkString("").toList
      s.map(x => {
        if (map.keySet.contains(x) && s.contains(map.get(x).get)) res = res+1

      })
      if (word.toLowerCase().distinct.length == res) res
      else 0
    }

  }
  println(numberOfSpecialChars("aaAbcBC"))
  println(numberOfSpecialChars("abc"))
  println(numberOfSpecialChars("deE"))


}
