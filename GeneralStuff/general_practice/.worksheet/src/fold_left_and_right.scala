object fold_left_and_right {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet");$skip(35); 
  
  val input = List(3, 5, 7, 11);System.out.println("""input  : List[Int] = """ + $show(input ));$skip(48); 
  
  def op(total: Int, cur: Int) = total + cur;System.out.println("""op: (total: Int, cur: Int)Int""");$skip(27); val res$0 = 
  
  input.foldLeft(0)(op);System.out.println("""res0: Int = """ + $show(res$0));$skip(38); 
  
  val mySquare = (x: Int) => x * x;System.out.println("""mySquare  : Int => Int = """ + $show(mySquare ));$skip(17); val res$1 = 
  
  mySquare(5);System.out.println("""res1: Int = """ + $show(res$1))}
  
}
