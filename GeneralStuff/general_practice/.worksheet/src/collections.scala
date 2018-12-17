object collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  println("Welcome to the Scala worksheet");$skip(36); 
  
  val array = Array(1,2,3,4,5,6);System.out.println("""array  : Array[Int] = """ + $show(array ));$skip(87); 
  // This converts this to an array of strings
  val result = array map { _.toString };System.out.println("""result  : Array[String] = """ + $show(result ))}
  
}
