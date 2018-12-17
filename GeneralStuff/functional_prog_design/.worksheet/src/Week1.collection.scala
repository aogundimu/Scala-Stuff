package Week1

object collection {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(79); 
  
  /// Example 1 Map/Flatmap
  val fruits = Seq("apple", "banana", "orange");System.out.println("""fruits  : Seq[String] = """ + $show(fruits ));$skip(28); val res$0 = 

	fruits map(_.toUpperCase);System.out.println("""res0: Seq[String] = """ + $show(res$0));$skip(33); val res$1 = 

  fruits flatMap(_.toUpperCase);System.out.println("""res1: Seq[Char] = """ + $show(res$1));$skip(228); 
  
  
  ///// Example 2 Map/FlatMap
  def toInt(s: String): Option[Int] = {
    try {
        Some(Integer.parseInt(s.trim))
    } catch {
        // catch Exception to catch null 's'
        case e: Exception => None
    }
  };System.out.println("""toInt: (s: String)Option[Int]""");$skip(52); 
  
  val strings = Seq("1", "2", "foo", "3", "bar");System.out.println("""strings  : Seq[String] = """ + $show(strings ));$skip(24); val res$2 = 
  
  strings map(toInt);System.out.println("""res2: Seq[Option[Int]] = """ + $show(res$2));$skip(28); val res$3 = 
  
  strings flatMap(toInt);System.out.println("""res3: Seq[Int] = """ + $show(res$3));$skip(35); val res$4 = 
  
  
  strings flatMap(toInt) sum;System.out.println("""res4: Int = """ + $show(res$4));$skip(40); 
  
  val mapResult = strings.map(toInt);System.out.println("""mapResult  : Seq[Option[Int]] = """ + $show(mapResult ));$skip(43); 
  
  val flattenResult = mapResult.flatten;System.out.println("""flattenResult  : Seq[Int] = """ + $show(flattenResult ));$skip(62); 
  
  ///// Example 3 Map/flatMap
  val list = List(1,2,3,4,5);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(38); 
  
  def g(v:Int) = List(v-1, v, v+1);System.out.println("""g: (v: Int)List[Int]""");$skip(25); val res$5 = 
  
  list.map(x => g(x));System.out.println("""res5: List[List[Int]] = """ + $show(res$5));$skip(26); val res$6 = 
  list.flatMap(x => g(x));System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(87); 
  
  ///// Example 4 Map/flatMap
  val map = Map(1 -> "one", 2 -> "two", 3 -> "three");System.out.println("""map  : scala.collection.immutable.Map[Int,String] = """ + $show(map ));$skip(33); val res$7 = 
  1 to map.size flatMap(map.get);System.out.println("""res7: scala.collection.immutable.IndexedSeq[String] = """ + $show(res$7));$skip(36); val res$8 = 
  1 to map.size flatMap(map.get(_));System.out.println("""res8: scala.collection.immutable.IndexedSeq[String] = """ + $show(res$8));$skip(29); val res$9 = 
  1 to map.size map(map.get);System.out.println("""res9: scala.collection.immutable.IndexedSeq[Option[String]] = """ + $show(res$9))}
                                                  
  
}
