package Week1

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  // This is wrong because type is needed
  // { case "ping" => "pong" }
  
  val f: String => String = { case "ping" => "pong" }
                                                  //> f  : String => String = <function1>
}