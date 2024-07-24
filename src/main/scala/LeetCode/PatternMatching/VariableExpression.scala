package LeetCode.PatternMatching

object VariableExpression extends App {
  val foodItem = "porridge"
  def goldilocks(expr: (String, String)) = {
    expr match {
      case (foodItem, _) => "eating"
      case ("chair", "Mama") => "sitting"
      case ("bed", "Baby") => "sleeping"
      case _ => "what?"
    }

  }
  println(goldilocks(("porridge", "Papa")))

}
