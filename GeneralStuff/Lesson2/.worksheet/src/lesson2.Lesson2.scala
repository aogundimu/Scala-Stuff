package lesson2

object Lesson2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 

  println("Welcome to the Scala worksheet");$skip(87); 
  
  /* def sumInts(a: Int, b: Int) = sum(x => x, a, b) */
  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(189); 
  
  def sum(f: Int => Int): (Int, Int) => Int = {
      def sumF(a: Int, b: Int): Int =
         if (a > b)
            0
         else
            f(a) + sumF(a + 1, b)
         sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(18); val res$0 = 
  
  sumInts(1,3);System.out.println("""res0: Int = """ + $show(res$0));$skip(171); 
  
  /****************                      *********************/
  
  /*def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b) */
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(46); 
  
  def cube(x : Int) : Int =
     x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(22); val res$1 = 
     
  sumCubes(1,2);System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
  sum(cube) (1,2);System.out.println("""res2: Int = """ + $show(res$2));$skip(145); 
  
  /*def sumFactorials(a: Int, b: Int) = sum(fact, a, b) */
  def fact(x: Int): Int = {
  			if (x == 0)
  			  1
  			else x * fact(x -1)
  };System.out.println("""fact: (x: Int)Int""");$skip(35); 
  
  def sumFactorials = sum(fact);System.out.println("""sumFactorials: => (Int, Int) => Int""");$skip(21); val res$3 = 
  sumFactorials(0,2);System.out.println("""res3: Int = """ + $show(res$3));$skip(81); 
  
  
  /**********    **************/
  def curriedSum (x: Int)(y: Int) = x + y;System.out.println("""curriedSum: (x: Int)(y: Int)Int""");$skip(19); val res$4 = 
  curriedSum(1)(2);System.out.println("""res4: Int = """ + $show(res$4));$skip(138); 
  
  def product(f: Int => Int)(a: Int, b: Int) : Int = {
      if ( a > b )
         1
      else
         f(a) * product(f)(a+1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$5 = 
  
  product(x => x * x)(3,4);System.out.println("""res5: Int = """ + $show(res$5));$skip(93); 
  
  /* Define factorial in terms of product */
  def fact2(n : Int) = product(x => x)(1, n);System.out.println("""fact2: (n: Int)Int""");$skip(11); val res$6 = 
  fact2(5);System.out.println("""res6: Int = """ + $show(res$6));$skip(268); 
  
  /************ function that generalizes product and sum ****************/
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
      if ( a > b )
        zero
      else combine(f(a), mapReduce(f, combine, zero)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(97); 
        
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x*y, 1)(a,b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(32); val res$7 = 
  
  product2(x => x * x)(3, 4);System.out.println("""res7: Int = """ + $show(res$7));$skip(48); 
  
  def fact3(n: Int) = product2(x => x)(1, n);System.out.println("""fact3: (n: Int)Int""");$skip(11); val res$8 = 
  fact3(5);System.out.println("""res8: Int = """ + $show(res$8))}
  
  
  /********     Fixed Point of a functions ***********/
  
}
