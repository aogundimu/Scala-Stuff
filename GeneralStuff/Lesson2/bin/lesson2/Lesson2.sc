package lesson2

object Lesson2 {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /* def sumInts(a: Int, b: Int) = sum(x => x, a, b) */
  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  
  def sum(f: Int => Int): (Int, Int) => Int = {
      def sumF(a: Int, b: Int): Int =
         if (a > b)
            0
         else
            f(a) + sumF(a + 1, b)
         sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  sumInts(1,3)                                    //> res0: Int = 6
  
  /****************                      *********************/
  
  /*def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b) */
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int
  
  def cube(x : Int) : Int =
     x * x * x                                    //> cube: (x: Int)Int
     
  sumCubes(1,2)                                   //> res1: Int = 9
  sum(cube) (1,2)                                 //> res2: Int = 9
  
  /*def sumFactorials(a: Int, b: Int) = sum(fact, a, b) */
  def fact(x: Int): Int = {
  			if (x == 0)
  			  1
  			else x * fact(x -1)
  }                                               //> fact: (x: Int)Int
  
  def sumFactorials = sum(fact)                   //> sumFactorials: => (Int, Int) => Int
  sumFactorials(0,2)                              //> res3: Int = 4
  
  
  /**********    **************/
  def curriedSum (x: Int)(y: Int) = x + y         //> curriedSum: (x: Int)(y: Int)Int
  curriedSum(1)(2)                                //> res4: Int = 3
  
  def product(f: Int => Int)(a: Int, b: Int) : Int = {
      if ( a > b )
         1
      else
         f(a) * product(f)(a+1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x * x)(3,4)                        //> res5: Int = 144
  
  /* Define factorial in terms of product */
  def fact2(n : Int) = product(x => x)(1, n)      //> fact2: (n: Int)Int
  fact2(5)                                        //> res6: Int = 120
  
  /************ function that generalizes product and sum ****************/
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
      if ( a > b )
        zero
      else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
        
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x*y, 1)(a,b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  
  product2(x => x * x)(3, 4)                      //> res7: Int = 144
  
  def fact3(n: Int) = product2(x => x)(1, n)      //> fact3: (n: Int)Int
  fact3(5)                                        //> res8: Int = 120
  
  
  /********     Fixed Point of a functions ***********/
  
}