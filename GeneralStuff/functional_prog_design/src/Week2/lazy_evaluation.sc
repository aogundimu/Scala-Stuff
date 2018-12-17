package Week2

object lazy_evaluation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def expr = {
  	val x = { print("x"); 1 }
  	lazy val y = { print("y"); 2 }
  	def z = { print("z"); 3 }
  	z + y + x + z + y + x
  }                                               //> expr: => Int
  
  expr                                            //> xzyzres0: Int = 12
}