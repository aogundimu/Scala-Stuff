package ChapterOne

object chapter_one {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(70); 
  
  
  var capital = Map(" US" -> "Washington", "France" -> "Paris");System.out.println("""capital  : scala.collection.immutable.Map[String,String] = """ + $show(capital ));$skip(34); 
  capital += ("Japan" -> "Tokyo");$skip(30); 
  println( capital("France"));$skip(29); 
  println( capital("Japan"));$skip(104); 
  
  def factorial(x: BigInt): BigInt =
     if (x == 0)
       1
     else
       x * factorial(x - 1);System.out.println("""factorial: (x: BigInt)BigInt""");$skip(24); val res$0 = 
       
  factorial(30);System.out.println("""res0: BigInt = """ + $show(res$0))}
}
