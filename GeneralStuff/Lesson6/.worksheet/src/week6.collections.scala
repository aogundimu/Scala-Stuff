package week6

object collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(50); 
  
  // Vectors
  val nums = Vector(1, 2, 3, -88);System.out.println("""nums  : scala.collection.immutable.Vector[Int] = """ + $show(nums ));$skip(46); 
  val names = Vector("Bob", "James", "Peter");System.out.println("""names  : scala.collection.immutable.Vector[String] = """ + $show(names ));$skip(105); 
  
  // They support the same operations as Lists with the exception of ::
  
  val xs = Array(1,2,3,44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(25); val res$0 = 
  
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(27); 
  
  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (c => c.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(29); val res$2 = 
  s exists ( c => c.isUpper);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(29); val res$3 = 
  s forall ( c => c.isUpper);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(30); 
  
  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(24); 
  val k: Range = 1 to 5;System.out.println("""k  : Range = """ + $show(k ));$skip(15); val res$4 = 
  1 to 10 by 3;System.out.println("""res4: scala.collection.immutable.Range = """ + $show(res$4));$skip(15); val res$5 = 
  6 to 1 by -2;System.out.println("""res5: scala.collection.immutable.Range = """ + $show(res$5));$skip(38); 
   
  val pairs = List(1, 2, 3) zip s;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(14); val res$6 = 
  pairs.unzip;System.out.println("""res6: (List[Int], List[Char]) = """ + $show(res$6));$skip(35); val res$7 = 
  
  s flatMap (c => List('.', c));System.out.println("""res7: String = """ + $show(res$7));$skip(10); val res$8 = 

  xs.sum;System.out.println("""res8: Int = """ + $show(res$8));$skip(9); val res$9 = 
  xs.max;System.out.println("""res9: Int = """ + $show(res$9));$skip(70); 

  def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""")}
}
