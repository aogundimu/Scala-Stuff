object paraMergeSort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  	val n = xs.length / 2
  	if (n == 0)
  	  xs
  	else {
  	  def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
  	     case (Nil, ys) => ys
  	     case (xs, Nil) => xs
  	     case (x :: xs1, y :: ys1) =>
  	        if (lt(x,y))
  	           x :: merge(xs1,ys)
  	        else
  	           y :: merge(xs, ys1)
  	  }
  	
  	  val (fst, snd) = xs splitAt n
  	  merge(msort(fst)(lt), msort(snd)(lt))
    }
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  
  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  msort(nums)((x: Int, y: Int) => x < y)          //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res1: List[String] = List(apple, banana, orange, pineapple)

  nums filter (x => x > 0)                        //> res2: List[Int] = List(2, 5, 7, 1)
  nums filterNot(x => x > 0)                      //> res3: List[Int] = List(-4)
  nums partition(x => x > 0)                      //> res4: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
   
  nums takeWhile(x => x > 0)                      //> res5: List[Int] = List(2)
  
  val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
  def pack[T](xs: List[T]): List[List[T]] = xs match {
  	 case Nil => Nil
  	 case x :: xs1 =>
  	    val (first, rest) = xs span(y => y == x)
  	    first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  pack(data)                                      //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )
  def encode[T](xs: List[T]): List[(T, Int)] =
     pack(xs) map(ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]
     
  encode(data)                                    //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}