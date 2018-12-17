package sum

object sum_of_integers {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sum(f: Int => Int, a: Int, b: Int): Int = {
  	def loop(a: Int, acc:Int): Int = {
  	   if (a > b)
  	     acc
  	   else
  	     loop(a+1, f(a) + acc)
  	}
  	
  	loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  sum(x => x * x, 3, 5)                           //> res0: Int = 50
  
  def something() = {
  	println("calling something")
  	1 // return value
  }                                               //> something: ()Int
  
  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }                                               //> callByName: (x: => Int)Unit
  
  def callByValue(x : Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }                                               //> callByValue: (x: Int)Unit
  
  callByName(something())                         //> calling something
                                                  //| x1=1
                                                  //| calling something
                                                  //| x2=1
  callByValue(something())                        //> calling something
                                                  //| x1=1
                                                  //| x2=1
}