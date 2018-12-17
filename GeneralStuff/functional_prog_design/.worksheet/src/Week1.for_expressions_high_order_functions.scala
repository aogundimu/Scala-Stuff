package Week1

object for_expressions_high_order_functions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); 
  println("Welcome to the Scala worksheet");$skip(83); 

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
			for (x <- xs) yield f(x);System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(103); 

	def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  	  for (x <- xs; y <- f(x)) yield y;System.out.println("""flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]""");$skip(90); 

	def filter[T](xs: List[T], p: T => Boolean): List[T] =
			for (x <- xs if p(x)) yield x;System.out.println("""filter: [T](xs: List[T], p: T => Boolean)List[T]""");$skip(174); 
			
  //for (x <- e1) yield e2
  
  def isPrime(v: Int): Boolean = {
  	if (v <= 1)
  		false
  	else if (v == 2)
  	  true
  	else !(2 to (v-1)).exists(x => v % x == 0)
  };System.out.println("""isPrime: (v: Int)Boolean""");$skip(24); 
  
  /////
  val n = 10;System.out.println("""n  : Int = """ + $show(n ));$skip(88); val res$0 = 
  for {
     i <- 1 until n
     j <- 1 until i
     if isPrime(i + j)
  } yield (i, j);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(142); val res$1 = 
  // translation of the same function above
  (1 until n).flatMap(i =>
     (1 until i).withFilter(j => isPrime(i+j))
     .map(j => (i, j)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1))}
}
