package LeetCode.PatternMatching

import scala.annotation.tailrec

object ReverseList extends App {
  val input = List(3,4,2,9,5,1)
  def revList(input: List[Int]): List[Int] = {
    input match {
      case Nil => Nil
      case head::tail => revList(tail) :+ head
    }
  }

  println(revList(input))

//  Using Tail recursion
def tailRevList(input: List[Int]): List[Int] = {
  @tailrec
    def revLs(original: List[Int], acc: List[Int]): List[Int] = {
      original match {
        case Nil => acc
        case head :: tail => revLs(tail, head :: acc)
      }
    }
    revLs(input, Nil)

  }
  println(tailRevList(input))

}
