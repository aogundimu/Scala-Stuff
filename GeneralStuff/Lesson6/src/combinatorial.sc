object combinatorial {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
  // Given a positive integer n, find all pairs of positive integers i and j
  // with 1 <= j < i < n such that i + j is prime
  val n = 7                                       //> n  : Int = 7
  
  (1 until n) flatMap (i =>
    (1 until i) map ( j => (i,j))) filter (pair =>
       isPrime(pair._1 + pair._2))                //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
       
       
  // Scala "for" expression
  
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield(i,j)                                    //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
   
  def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
     (for( (x,y) <- xs zip ys ) yield x*y).sum    //> scalarProduct: (xs: List[Double], ys: List[Double])Double
}