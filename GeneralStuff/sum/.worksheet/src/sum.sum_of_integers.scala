package sum

object sum_of_integers {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(188); 
  
  def sum(f: Int => Int, a: Int, b: Int): Int = {
  	def loop(a: Int, acc:Int): Int = {
  	   if (a > b)
  	     acc
  	   else
  	     loop(a+1, f(a) + acc)
  	}
  	
  	loop(a, 0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(27); val res$0 = 
  
  sum(x => x * x, 3, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(82); 
  
  def something() = {
  	println("calling something")
  	1 // return value
  };System.out.println("""something: ()Int""");$skip(85); 
  
  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  };System.out.println("""callByName: (x: => Int)Unit""");$skip(84); 
  
  def callByValue(x : Int) = {
    println("x1=" + x)
    println("x2=" + x)
  };System.out.println("""callByValue: (x: Int)Unit""");$skip(29); 
  
  callByName(something());$skip(27); 
  callByValue(something())}
}
