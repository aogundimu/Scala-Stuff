package week6

object collections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Vectors
  val nums = Vector(1, 2, 3, -88)                 //> nums  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, -88)
  val names = Vector("Bob", "James", "Peter")     //> names  : scala.collection.immutable.Vector[String] = Vector(Bob, James, Pete
                                                  //| r)
  
  // They support the same operations as Lists with the exception of ::
  
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  s exists ( c => c.isUpper)                      //> res2: Boolean = true
  s forall ( c => c.isUpper)                      //> res3: Boolean = false
  
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  val k: Range = 1 to 5                           //> k  : Range = Range(1, 2, 3, 4, 5)
  1 to 10 by 3                                    //> res4: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res5: scala.collection.immutable.Range = Range(6, 4, 2)
   
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res6: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (c => List('.', c))                   //> res7: String = .H.e.l.l.o. .W.o.r.l.d

  xs.sum                                          //> res8: Int = 50
  xs.max                                          //> res9: Int = 44

  def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
}