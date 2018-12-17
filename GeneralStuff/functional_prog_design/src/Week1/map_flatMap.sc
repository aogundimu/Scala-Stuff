package Week1

object map_flatMap {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Map works by applying a function to each element in the lis
  val l = List(1,2,3,4,5)                         //> l  : List[Int] = List(1, 2, 3, 4, 5)
  l.map( x => x*2)                                //> res0: List[Int] = List(2, 4, 6, 8, 10)

	// So there are some occasions where you want to return a sequence
	// or list from the function, for example an Option
	def f(x: Int) = if (x > 2) Some(x) else None
                                                  //> f: (x: Int)Option[Int]
  l.map( x => f(x))                               //> res1: List[Option[Int]] = List(None, None, Some(3), Some(4), Some(5))

	
	////  Flat map
	// flatMap works applying a function that returns a sequence for each
	// element in the list, and flattening the results into the original list.
	
	def g(v:Int) = List(v-1, v, v+1)          //> g: (v: Int)List[Int]
	l.map(x => f(x))                          //> res2: List[Option[Int]] = List(None, None, Some(3), Some(4), Some(5))
	l.flatMap(x => g(x) )                     //> res3: List[Int] = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)

	// The Option classn- an option can be considered a sequence with
	// 0 or 1 item
  l.flatMap(x => f(x))                            //> res4: List[Int] = List(3, 4, 5)

	// Now working with Map from the collection package
	// A Map can be thought of as a sequence of Tuples
	val m = Map(1 -> 2, 2 -> 4, 3 -> 6)       //> m  : scala.collection.immutable.Map[Int,Int] = Map(1 -> 2, 2 -> 4, 3 -> 6)
	m.toList                                  //> res5: List[(Int, Int)] = List((1,2), (2,4), (3,6))
  
  /// t is a tuple
	val t = (1,2)                             //> t  : (Int, Int) = (1,2)
	// the first element of t
	t._1                                      //> res6: Int = 1
	// the second element of t
	t._2                                      //> res7: Int = 2

  // Applying map and flatMap to a Map?
  // Double all the values of a Map
  m.mapValues(v => v*2)                           //> res8: scala.collection.immutable.Map[Int,Int] = Map(1 -> 4, 2 -> 8, 3 -> 12
                                                  //| )
  
  // apply fuction f to all the values in a Map
  m.mapValues(v => f(v))                          //> res9: scala.collection.immutable.Map[Int,Option[Int]] = Map(1 -> None, 2 ->
                                                  //|  Some(4), 3 -> Some(6))
  // This returns a list of the second items of the tuples in the Map
  m.flatMap(e => List(e._2))                      //> res10: scala.collection.immutable.Iterable[Int] = List(2, 4, 6)
  // This returns the tuples in the map in a List
  m.flatMap(e => List(e))                         //> res11: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2, 2 -> 4, 3 -> 6
                                                  //| )
  // Ok so we are pretty close to using options with flatMap,
  // we need to filter out our None’s, we can do returning a list
  // with just e => f(e._2) and we’ll get the list of values without
  // the None’s, but that isn’t really what I want. What I need to
  // do is return an Option containing a tuple. So here’s our updated function:
  def h(k:Int, v:Int) = if (v > 2) Some(k -> v) else None
                                                  //> h: (k: Int, v: Int)Option[(Int, Int)]
  m.flatMap( e => h(e._1, e._2) )                 //> res12: scala.collection.immutable.Map[Int,Int] = Map(2 -> 4, 3 -> 6)

  // The following is wrong
  // m.flatMap( (k,v) => h(k,v) )
  // What follow is right - The answer is seems is that an unapply is
  // normally only executed in a PartialFunction, which in scala is most
  // easily defined as a case statement. So this is the code that
  // works as expected:
  // Note that we switch to using curly braces, indicating a function block
  // rather than parameters, and the function is a case statement. This means
  // that the function block we pass to flatMap is a partialFunction that is
  // only invoked for items that match the case statement, and in the case
  // statement the unapply method on tuple is called to extract the contents
  // of the tuple into the variables.
  m.flatMap{ case (k,v) => h (k,v) }              //> res13: scala.collection.immutable.Map[Int,Int] = Map(2 -> 4, 3 -> 6)

	m.filter(e => f(e._2) != None)            //> res14: scala.collection.immutable.Map[Int,Int] = Map(2 -> 4, 3 -> 6)
	m.filter { case (k,v) => f(v) != None }   //> res15: scala.collection.immutable.Map[Int,Int] = Map(2 -> 4, 3 -> 6)
	m.filter { case (k,v) => f(v).isDefined } //> res16: scala.collection.immutable.Map[Int,Int] = Map(2 -> 4, 3 -> 6)
}