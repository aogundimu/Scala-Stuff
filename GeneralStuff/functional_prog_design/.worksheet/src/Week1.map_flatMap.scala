package Week1

object map_flatMap {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(94); 
  
  // Map works by applying a function to each element in the lis
  val l = List(1,2,3,4,5);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(19); val res$0 = 
  l.map( x => x*2);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(168); 

	// So there are some occasions where you want to return a sequence
	// or list from the function, for example an Option
	def f(x: Int) = if (x > 2) Some(x) else None;System.out.println("""f: (x: Int)Option[Int]""");$skip(20); val res$1 = 
  l.map( x => f(x));System.out.println("""res1: List[Option[Int]] = """ + $show(res$1));$skip(202); 

	
	////  Flat map
	// flatMap works applying a function that returns a sequence for each
	// element in the list, and flattening the results into the original list.
	
	def g(v:Int) = List(v-1, v, v+1);System.out.println("""g: (v: Int)List[Int]""");$skip(18); val res$2 = 
	l.map(x => f(x));System.out.println("""res2: List[Option[Int]] = """ + $show(res$2));$skip(23); val res$3 = 
	l.flatMap(x => g(x) );System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(107); val res$4 = 

	// The Option classn- an option can be considered a sequence with
	// 0 or 1 item
  l.flatMap(x => f(x));System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(143); 

	// Now working with Map from the collection package
	// A Map can be thought of as a sequence of Tuples
	val m = Map(1 -> 2, 2 -> 4, 3 -> 6);System.out.println("""m  : scala.collection.immutable.Map[Int,Int] = """ + $show(m ));$skip(10); val res$5 = 
	m.toList;System.out.println("""res5: List[(Int, Int)] = """ + $show(res$5));$skip(37); 
  
  /// t is a tuple
	val t = (1,2);System.out.println("""t  : (Int, Int) = """ + $show(t ));$skip(33); val res$6 = 
	// the first element of t
	t._1;System.out.println("""res6: Int = """ + $show(res$6));$skip(34); val res$7 = 
	// the second element of t
	t._2;System.out.println("""res7: Int = """ + $show(res$7));$skip(101); val res$8 = 

  // Applying map and flatMap to a Map?
  // Double all the values of a Map
  m.mapValues(v => v*2);System.out.println("""res8: scala.collection.immutable.Map[Int,Int] = """ + $show(res$8));$skip(76); val res$9 = 
  
  // apply fuction f to all the values in a Map
  m.mapValues(v => f(v));System.out.println("""res9: scala.collection.immutable.Map[Int,Option[Int]] = """ + $show(res$9));$skip(99); val res$10 = 
  // This returns a list of the second items of the tuples in the Map
  m.flatMap(e => List(e._2));System.out.println("""res10: scala.collection.immutable.Iterable[Int] = """ + $show(res$10));$skip(76); val res$11 = 
  // This returns the tuples in the map in a List
  m.flatMap(e => List(e));System.out.println("""res11: scala.collection.immutable.Map[Int,Int] = """ + $show(res$11));$skip(402); 
  // Ok so we are pretty close to using options with flatMap,
  // we need to filter out our None’s, we can do returning a list
  // with just e => f(e._2) and we’ll get the list of values without
  // the None’s, but that isn’t really what I want. What I need to
  // do is return an Option containing a tuple. So here’s our updated function:
  def h(k:Int, v:Int) = if (v > 2) Some(k -> v) else None;System.out.println("""h: (k: Int, v: Int)Option[(Int, Int)]""");$skip(34); val res$12 = 
  m.flatMap( e => h(e._1, e._2) );System.out.println("""res12: scala.collection.immutable.Map[Int,Int] = """ + $show(res$12));$skip(754); val res$13 = 

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
  m.flatMap{ case (k,v) => h (k,v) };System.out.println("""res13: scala.collection.immutable.Map[Int,Int] = """ + $show(res$13));$skip(33); val res$14 = 

	m.filter(e => f(e._2) != None);System.out.println("""res14: scala.collection.immutable.Map[Int,Int] = """ + $show(res$14));$skip(41); val res$15 = 
	m.filter { case (k,v) => f(v) != None };System.out.println("""res15: scala.collection.immutable.Map[Int,Int] = """ + $show(res$15));$skip(43); val res$16 = 
	m.filter { case (k,v) => f(v).isDefined };System.out.println("""res16: scala.collection.immutable.Map[Int,Int] = """ + $show(res$16))}
}
