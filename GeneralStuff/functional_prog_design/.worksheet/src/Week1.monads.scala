package Week1

object monads {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(48); val res$0 = 
  
  for {
    x <- List(1, 2)
  } yield(x + 2);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(33); val res$1 = 
  
  List(1, 2) map (x => x + 2);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(28); 
  
  val first = List(1, 2);System.out.println("""first  : List[Int] = """ + $show(first ));$skip(24); 
  val next = List(8, 9);System.out.println("""next  : List[Int] = """ + $show(next ));$skip(57); val res$2 = 

  for {
     i <- first
     j <- next
  } yield(i * j);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(42); 
  
  val last = List("ab", "cde", "fghi");System.out.println("""last  : List[String] = """ + $show(last ));$skip(80); val res$3 = 

  for {
    i <- first
    j <- next
    k <- last
  } yield(i * j * k.length);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(47); 
  
  val f = (i: Int) => List(i - 1, i, i + 1);System.out.println("""f  : Int => List[Int] = """ + $show(f ));$skip(27); 
  val list = List(5, 6, 7);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(27); 
  println(list.flatMap(f))}
  
  /////////////////// Second Time Around
  trait M[T] {
    def flatMap[U](f: T => M[U]): M[U]
    def unit[T](x: T): M[T]
	}
  
}
