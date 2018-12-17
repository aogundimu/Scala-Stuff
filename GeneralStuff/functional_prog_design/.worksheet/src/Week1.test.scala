package Week1

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet");$skip(136); 
  
  
  // This is wrong because type is needed
  // { case "ping" => "pong" }
  
  val f: String => String = { case "ping" => "pong" };System.out.println("""f  : String => String = """ + $show(f ))}
}
