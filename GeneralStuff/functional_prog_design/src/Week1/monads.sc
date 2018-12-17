package Week1

object monads {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  for {
    x <- List(1, 2)
  } yield(x + 2)                                  //> res0: List[Int] = List(3, 4)
  
  List(1, 2) map (x => x + 2)                     //> res1: List[Int] = List(3, 4)
  
  val first = List(1, 2)                          //> first  : List[Int] = List(1, 2)
  val next = List(8, 9)                           //> next  : List[Int] = List(8, 9)

  for {
     i <- first
     j <- next
  } yield(i * j)                                  //> res2: List[Int] = List(8, 9, 16, 18)
  
  val last = List("ab", "cde", "fghi")            //> last  : List[String] = List(ab, cde, fghi)

  for {
    i <- first
    j <- next
    k <- last
  } yield(i * j * k.length)                       //> res3: List[Int] = List(16, 24, 32, 18, 27, 36, 32, 48, 64, 36, 54, 72)
  
  val f = (i: Int) => List(i - 1, i, i + 1)       //> f  : Int => List[Int] = <function1>
  val list = List(5, 6, 7)                        //> list  : List[Int] = List(5, 6, 7)
  println(list.flatMap(f))                        //> List(4, 5, 6, 5, 6, 7, 6, 7, 8)
  
  /////////////////// Second Time Around
  trait M[T] {
    def flatMap[U](f: T => M[U]): M[U]
    def unit[T](x: T): M[T]
	}		
  
}