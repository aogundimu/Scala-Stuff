package Week1

object for_expressions_high_order_functions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
			for (x <- xs) yield f(x)  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

	def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  	  for (x <- xs; y <- f(x)) yield y        //> flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]

	def filter[T](xs: List[T], p: T => Boolean): List[T] =
			for (x <- xs if p(x)) yield x
                                                  //> filter: [T](xs: List[T], p: T => Boolean)List[T]
			
  //for (x <- e1) yield e2
  
  def isPrime(v: Int): Boolean = {
  	if (v <= 1)
  		false
  	else if (v == 2)
  	  true
  	else !(2 to (v-1)).exists(x => v % x == 0)
  }                                               //> isPrime: (v: Int)Boolean
  
  /////
  val n = 10                                      //> n  : Int = 10
  for {
     i <- 1 until n
     j <- 1 until i
     if isPrime(i + j)
  } yield (i, j)                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (9,
                                                  //| 4), (9,8))
  // translation of the same function above
  (1 until n).flatMap(i =>
     (1 until i).withFilter(j => isPrime(i+j))
     .map(j => (i, j)))                           //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (9,
                                                  //| 4), (9,8))
}