object week2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(170); 

  def mapASegSeq[A,B](inp: Array[A], left: Int, right: Int, f: A => B, out: Array[B]) {
		var i = left
		while( i < right ) {
			out(i) = f(inp(i))
			i = i + 1
		}
  };System.out.println("""mapASegSeq: [A, B](inp: Array[A], left: Int, right: Int, f: A => B, out: Array[B])Unit""");$skip(31); 
  
  val in = Array(2,3,4,5,6);System.out.println("""in  : Array[Int] = """ + $show(in ));$skip(29); 
  val out = Array(0,0,0,0,0);System.out.println("""out  : Array[Int] = """ + $show(out ));$skip(27); 
  val f = (x:Int) => x * x;System.out.println("""f  : Int => Int = """ + $show(f ));$skip(31); 
  mapASegSeq(in, 1, 3, f, out);$skip(6); val res$0 = 
  out;System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(55); val res$1 = 
  
 
  
  //// Example map
  List(1,3,8).map(x => x*x);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(24); val res$2 = 
  
  List(1,3,8).map(f);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(72); val res$3 = 
  
  /// Example fold or reduce
  List(1,3,8).fold(100)((s,x) => s + x);System.out.println("""res3: Int = """ + $show(res$3));$skip(78); val res$4 = 
  
  // ((100 - 1) - 3) - 8 == 88
  List(1,3,8).foldLeft(100)((s,x) => s - x);System.out.println("""res4: Int = """ + $show(res$4));$skip(79); val res$5 = 
   
  // 1 - (3 - (8-100)) == -94
  List(1,3,8).foldRight(100)((s,x) => s - x);System.out.println("""res5: Int = """ + $show(res$5));$skip(71); val res$6 = 
 
  
  //  (1 - 3) - 8 == -10
  List(1,3,8).reduceLeft((s,x) => s - x);System.out.println("""res6: Int = """ + $show(res$6));$skip(66); val res$7 = 
 
  // 1 - (3 - 8) == 6
  List(1,3,8).reduceRight((s,x) => s - x);System.out.println("""res7: Int = """ + $show(res$7));$skip(90); val res$8 = 
  
  //List(1,3,8).scanLeft() ((s,x) => )
  
  List(1,3,8).scanLeft(100) ((s,x) => s + x);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(38); val res$9 = 
  
  List(1,3,8).scanLeft(100)(_ + _);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(39); val res$10 = 
  
  List(1,3,8).scanRight(100)(_ + _);System.out.println("""res10: List[Int] = """ + $show(res$10))}

}
