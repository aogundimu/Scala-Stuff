package week2

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(161); 
  
  def factorial(n: Int): Int = {
     def loop(acc: Int, n: Int): Int =
        if (n == 0) acc
        else loop( acc * n, n -1 )
     
     loop(1, n);
  };System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$0 = 
  
  factorial(3);System.out.println("""res0: Int = """ + $show(res$0))}
}
