object week2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def mapASegSeq[A,B](inp: Array[A], left: Int, right: Int, f: A => B, out: Array[B]) {
		var i = left
		while( i < right ) {
			out(i) = f(inp(i))
			i = i + 1
		}
  }                                               //> mapASegSeq: [A, B](inp: Array[A], left: Int, right: Int, f: A => B, out: Arr
                                                  //| ay[B])Unit
  
  val in = Array(2,3,4,5,6)                       //> in  : Array[Int] = Array(2, 3, 4, 5, 6)
  val out = Array(0,0,0,0,0)                      //> out  : Array[Int] = Array(0, 0, 0, 0, 0)
  val f = (x:Int) => x * x                        //> f  : Int => Int = <function1>
  mapASegSeq(in, 1, 3, f, out)
  out                                             //> res0: Array[Int] = Array(0, 9, 16, 0, 0)
  
 
  
  //// Example map
  List(1,3,8).map(x => x*x)                       //> res1: List[Int] = List(1, 9, 64)
  
  List(1,3,8).map(f)                              //> res2: List[Int] = List(1, 9, 64)
  
  /// Example fold or reduce
  List(1,3,8).fold(100)((s,x) => s + x)           //> res3: Int = 112
  
  // ((100 - 1) - 3) - 8 == 88
  List(1,3,8).foldLeft(100)((s,x) => s - x)       //> res4: Int = 88
   
  // 1 - (3 - (8-100)) == -94
  List(1,3,8).foldRight(100)((s,x) => s - x)      //> res5: Int = -94
 
  
  //  (1 - 3) - 8 == -10
  List(1,3,8).reduceLeft((s,x) => s - x)          //> res6: Int = -10
 
  // 1 - (3 - 8) == 6
  List(1,3,8).reduceRight((s,x) => s - x)         //> res7: Int = 6
  
  //List(1,3,8).scanLeft() ((s,x) => ) 
  
  List(1,3,8).scanLeft(100) ((s,x) => s + x)      //> res8: List[Int] = List(100, 101, 104, 112)
  
  List(1,3,8).scanLeft(100)(_ + _)                //> res9: List[Int] = List(100, 101, 104, 112)
  
  List(1,3,8).scanRight(100)(_ + _)               //> res10: List[Int] = List(112, 111, 108, 100)

}