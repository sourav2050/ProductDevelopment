package scala.ListGpt

import java.util

object ParenthesesChecker {
//  def main(arr: Array[String]): Unit = {
    val expressions = List(
      "()[{}]", // true
      "{[()]}<>[<{}><>]", // true
      "()[{)]", // false
      "()[[][]" // false
    )
    println(expressions)

    def isBalanced(expression: String) = {
      val matchPairs = Map(')' -> '(', ']'-> '[', '}' -> '{', '>' -> '<')
      val stack1 = new util.Stack[Char]
      expression.mkString.map(y =>
        if(matchPairs.values.toSet.contains(y)) {
          stack1.push(y)
//          println(stack1)
        }
        else if (matchPairs.keySet.contains(y)) {
          if (stack1.isEmpty || stack1.pop() != matchPairs(y))
            false
        }
      )
      stack1.isEmpty
    }

//    println(isBalanced("{[()]}<>[<}{><>]"))


    import scala.collection.mutable

//    object BalancedBrackets {

      // function to check if brackets are balanced
      def areBracketsBalanced(expr: String): Boolean = {
        // Using mutable.Stack to emulate Java's Deque
        val stack = new mutable.Stack[Char]()

        // Traversing the Expression
        for (x <- expr) {
          x match {
            case '(' | '[' | '{' =>
              // Push the element in the stack
              stack.push(x)

            case ')' =>
              if (stack.isEmpty || stack.pop() != '(') return false

            case '}' =>
              if (stack.isEmpty || stack.pop() != '{') return false

            case ']' =>
              if (stack.isEmpty || stack.pop() != '[') return false

            case _ =>
            // Ignore other characters
          }
        }

        // Check Empty Stack
        stack.isEmpty
      }

      // Driver code
      def main(args: Array[String]): Unit = {
        val expr = "{[()]}<>[<}{><>]"

        // Function call
        if (areBracketsBalanced(expr))
          println("Balanced")
        else
          println("Not Balanced")
      }
//    }

//  }
}
