object collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  println("Welcome to the Scala worksheet");$skip(50); 
  
  // Vectors
  val nums = Vector(1, 2, 3, -88);System.out.println("""nums  : scala.collection.immutable.Vector[Int] = """ + $show(nums ));$skip(46); 
  val names = Vector("Bob", "James", "Peter");System.out.println("""names  : scala.collection.immutable.Vector[String] = """ + $show(names ));$skip(105); 
  
  // They support the same operations as Lists with the exception of ::
  
  val xs = Array(1,2,3,44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(25); val res$0 = 
  
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(27); 
  
  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (c => c.isUpper);System.out.println("""res1: <error> = """ + $show(res$1));$skip(30); 
  
  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(24); 
  val s: Range = 1 to 5;System.out.println("""s  : Range = """ + $show(s ))}
  
}
