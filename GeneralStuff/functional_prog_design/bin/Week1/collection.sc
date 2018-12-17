package Week1

object collection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /// Example 1 Map/Flatmap
  val fruits = Seq("apple", "banana", "orange")   //> fruits  : Seq[String] = List(apple, banana, orange)

	fruits map(_.toUpperCase)                 //> res0: Seq[String] = List(APPLE, BANANA, ORANGE)

  fruits flatMap(_.toUpperCase)                   //> res1: Seq[Char] = List(A, P, P, L, E, B, A, N, A, N, A, O, R, A, N, G, E)
  
  
  ///// Example 2 Map/FlatMap
  def toInt(s: String): Option[Int] = {
    try {
        Some(Integer.parseInt(s.trim))
    } catch {
        // catch Exception to catch null 's'
        case e: Exception => None
    }
  }                                               //> toInt: (s: String)Option[Int]
  
  val strings = Seq("1", "2", "foo", "3", "bar")  //> strings  : Seq[String] = List(1, 2, foo, 3, bar)
  
  strings map(toInt)                              //> res2: Seq[Option[Int]] = List(Some(1), Some(2), None, Some(3), None)
  
  strings flatMap(toInt)                          //> res3: Seq[Int] = List(1, 2, 3)
  
  
  strings flatMap(toInt) sum                      //> res4: Int = 6
  
  val mapResult = strings.map(toInt)              //> mapResult  : Seq[Option[Int]] = List(Some(1), Some(2), None, Some(3), None)
  
  val flattenResult = mapResult.flatten           //> flattenResult  : Seq[Int] = List(1, 2, 3)
  
  ///// Example 3 Map/flatMap
  val list = List(1,2,3,4,5)                      //> list  : List[Int] = List(1, 2, 3, 4, 5)
  
  def g(v:Int) = List(v-1, v, v+1)                //> g: (v: Int)List[Int]
  
  list.map(x => g(x))                             //> res5: List[List[Int]] = List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4), Li
                                                  //| st(3, 4, 5), List(4, 5, 6))
  list.flatMap(x => g(x))                         //> res6: List[Int] = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)
  
  ///// Example 4 Map/flatMap
  val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
                                                  //> map  : scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 
                                                  //| 3 -> three)
  1 to map.size flatMap(map.get)                  //> res7: scala.collection.immutable.IndexedSeq[String] = Vector(one, two, three
                                                  //| )
  1 to map.size flatMap(map.get(_))               //> res8: scala.collection.immutable.IndexedSeq[String] = Vector(one, two, three
                                                  //| )
  1 to map.size map(map.get)                      //> res9: scala.collection.immutable.IndexedSeq[Option[String]] = Vector(Some(o
                                                  //| ne), Some(two), Some(three))
                                                  
  
}