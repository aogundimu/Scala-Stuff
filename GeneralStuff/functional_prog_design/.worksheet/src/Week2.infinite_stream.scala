package Week2

object infinite_stream {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala worksheet");$skip(95); 
  
  // A stream consisting of n followed by
  def from(n: Int): Stream[Int] = n #:: from(n+1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(49); 
  
  // All natural numbers
  val nats = from(0);System.out.println("""nats  : Stream[Int] = """ + $show(nats ));$skip(53); 
  // All multiples of 4
  val m4s = nats map (_ * 4);System.out.println("""m4s  : scala.collection.immutable.Stream[Int] = """ + $show(m4s ));$skip(81); val res$0 = 
  
  // Take first 100 elements and convert it to a list
  (m4s take 100).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(100); 
  
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(35); 
    
  val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(29); val res$1 = 
  
  primes.take(100).toList;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(99); 
   
  def isGoodEnough(guess: Double, x: Double) =
     math.abs((guess * guess - x) / x) < 0.0001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(197); 
     
  def sqrtStream(x: Double): Stream[Double] = {
     def improve(guess: Double) = (guess + x / guess) / 2
     lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
     guesses
  };System.out.println("""sqrtStream: (x: Double)Stream[Double]""");$skip(35); val res$2 = 
  
  sqrtStream(4).take(10).toList;System.out.println("""res2: List[Double] = """ + $show(res$2));$skip(62); val res$3 = 
  
  sqrtStream(4).filter(isGoodEnough(_, 4)).take(10).toList;System.out.println("""res3: List[Double] = """ + $show(res$3));$skip(15); 
  
  val N = 2;System.out.println("""N  : Int = """ + $show(N ));$skip(28); 
  val xs = from(1) map(_*N);System.out.println("""xs  : scala.collection.immutable.Stream[Int] = """ + $show(xs ));$skip(35); 
  val ys = from(1) filter(_%N ==0);System.out.println("""ys  : scala.collection.immutable.Stream[Int] = """ + $show(ys ))}
}
