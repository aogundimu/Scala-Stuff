object paraMergeSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  println("Welcome to the Scala worksheet");$skip(495); 
  
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
  };System.out.println("""msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]""");$skip(37); 
  
  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(41); val res$0 = 
  msort(nums)((x: Int, y: Int) => x < y);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(62); val res$1 = 
  msort(fruits)((x: String, y: String) => x.compareTo(y) < 0);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(28); val res$2 = 

  nums filter (x => x > 0);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(29); val res$3 = 
  nums filterNot(x => x > 0);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(29); val res$4 = 
  nums partition(x => x > 0);System.out.println("""res4: (List[Int], List[Int]) = """ + $show(res$4));$skip(33); val res$5 = 
   
  nums takeWhile(x => x > 0);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(56); 
  
  val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[String] = """ + $show(data ));$skip(175); 
  def pack[T](xs: List[T]): List[List[T]] = xs match {
  	 case Nil => Nil
  	 case x :: xs1 =>
  	    val (first, rest) = xs span(y => y == x)
  	    first :: pack(rest)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(16); val res$6 = 
  
  pack(data);System.out.println("""res6: List[List[String]] = """ + $show(res$6));$skip(93); 
  def encode[T](xs: List[T]): List[(T, Int)] =
     pack(xs) map(ys => (ys.head, ys.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(21); val res$7 = 
     
  encode(data);System.out.println("""res7: List[(String, Int)] = """ + $show(res$7))}
}
