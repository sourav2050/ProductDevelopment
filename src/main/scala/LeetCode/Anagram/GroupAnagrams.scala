package LeetCode.Anagram
import scala.collection.mutable.Map

object GroupAnagrams extends App {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val map: Map[String, List[String]] = Map[String, List[String]]()
    val temp = strs.foreach(x => {
      val sortedWord = x.sorted
      if (map.keySet.contains(sortedWord)) {
        map(sortedWord) = map(sortedWord) :+ x //list(eat):+ "tea"

      } else {
        map += (sortedWord -> (List.empty[String] :+ x))
      }
    })
    map.values.toList
  }
  val Input = Array("eat","tea","tan","ate","nat","bat")

  println(groupAnagrams(Input))

//  Time Complexity : O(N∗M∗Log(M))  // Log(M) represents for sorting and searching
//  Space Complexity: O(N∗M)

  /*
  Input: strs = ["eat","tea","tan","ate","nat","bat"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
   */

}
