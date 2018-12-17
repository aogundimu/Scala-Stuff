object combinatorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  println("Welcome to the Scala worksheet");$skip(72); 
  
  def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(139); 
  // Given a positive integer n, find all pairs of positive integers i and j
  // with 1 <= j < i < n such that i + j is prime
  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(117); val res$0 = 
  
  (1 until n) flatMap (i =>
    (1 until i) map ( j => (i,j))) filter (pair =>
       isPrime(pair._1 + pair._2));System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(130); val res$1 = 
       
       
  // Scala "for" expression
  
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield(i,j);System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(118); 
   
  def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
     (for( (x,y) <- xs zip ys ) yield x*y).sum;System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""")}
}
