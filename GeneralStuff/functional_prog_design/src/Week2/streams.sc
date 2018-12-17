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
  }

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }

	streamRange(1, 10).take(3).toList
	
  def isPrime(v: Int): Boolean = {
    if (v <= 1)
      false
    else if (v == 2)
      true
    else !(2 to (v - 1)).exists(x => v % x == 0)
  }

  //val s = streamRange(1,10)
  ((1000 to 10000) filter isPrime)(1)
  
  def listRange(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi) Nil
    else lo :: listRange(lo + 1, hi)
  }

  listRange(1, 10)

}