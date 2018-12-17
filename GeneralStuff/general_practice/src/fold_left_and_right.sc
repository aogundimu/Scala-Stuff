object fold_left_and_right {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val input = List(3, 5, 7, 11)                   //> input  : List[Int] = List(3, 5, 7, 11)
  
  def op(total: Int, cur: Int) = total + cur      //> op: (total: Int, cur: Int)Int
  
  input.foldLeft(0)(op)                           //> res0: Int = 26
  
  val mySquare = (x: Int) => x * x                //> mySquare  : Int => Int = <function1>
  
  mySquare(5)                                     //> res1: Int = 25
  
}