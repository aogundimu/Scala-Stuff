package Week2

object streams {
  //println("Welcome to the Scala worksheet")

  trait Stream[+A] extends Seq[A] {
    def isEmpty: Boolean
    def head: A
    def tail: Stream[A]
  }

  object Stream {
    def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
      def isEmpty = false
      def head = hd
      lazy val tail = tl
    }

    val empty = new Stream[Nothing] {
      def isEmpty = true
      def head = throw new NoSuchElementException("empty.head")
      def tail = throw new NoSuchElementException("empty.tail")
    }
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(699); 

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  };System.out.println("""streamRange: (lo: Int, hi: Int)Week2.streams.Stream[Int]""");$skip(36); val res$0 = 

	streamRange(1, 10).take(3).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(150); 
	
  def isPrime(v: Int): Boolean = {
    if (v <= 1)
      false
    else if (v == 2)
      true
    else !(2 to (v - 1)).exists(x => v % x == 0)
  };System.out.println("""isPrime: (v: Int)Boolean""");$skip(69); val res$1 = 

  //val s = streamRange(1,10)
  ((1000 to 10000) filter isPrime)(1);System.out.println("""res1: Int = """ + $show(res$1));$skip(115); 
  
  def listRange(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi) Nil
    else lo :: listRange(lo + 1, hi)
  };System.out.println("""listRange: (lo: Int, hi: Int)List[Int]""");$skip(20); val res$2 = 

  listRange(1, 10);System.out.println("""res2: List[Int] = """ + $show(res$2))}

}
