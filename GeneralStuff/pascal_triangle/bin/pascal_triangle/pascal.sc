package pascal_triangle

object pascal {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

    /* print(pascal4(7,14))  */
    
    
    println("Pascal's Triangle")                  //> Pascal's Triangle
    for (row <- 0 to 15) {
      for (col <- 0 to row)
        print(pascal4(col, row) + " ")
      println()
    }                                             //> 1 
                                                  //| 1 1 
                                                  //| 1 2 1 
                                                  //| 1 3 3 1 
                                                  //| 1 4 6 4 1 
                                                  //| 1 5 10 10 5 1 
                                                  //| 1 6 15 20 15 6 1 
                                                  //| 1 7 21 35 35 21 7 1 
                                                  //| 1 8 28 56 70 56 28 8 1 
                                                  //| 1 9 36 84 126 126 84 36 9 1 
                                                  //| 1 10 45 120 210 252 210 120 45 10 1 
                                                  //| 1 11 55 165 330 462 462 330 165 55 11 1 
                                                  //| 1 12 66 220 495 792 924 792 495 220 66 12 1 
                                                  //| 1 13 78 286 715 1287 1716 1716 1287 715 286 78 13 1 
                                                  //| 1 14 91 364 1001 2002 3003 3432 3003 2002 1001 364 91 14 1 
                                                  //| 1 15 105 455 1365 3003 5005 6435 6435 5005 3003 1365 455 105 15 1 
    
    
   def pascal4(c: Int, r:Int) : Int = {
       
       def loop(end:Int, cache:Array[Int], col:Int, row:Int) : Int = {
          if ( row == end ) {
            /* return the value */
            cache(col);
          } else {
             var arr = Array.ofDim[Int]( cache.length + 1)
             for( i <- 0 until arr.length ) {
                if ( (i == 0) || (i == arr.length-1) ) {
                    arr(i) = 1
                } else {
                    arr(i) = cache(i-1) + cache(i)
                }
             }
             
             loop(end, arr, col, row+1);
          }
       }
       
       /* loop(1, Array.ofDim[Int](1), 2, 2) */
       val a = Array.ofDim[Int](1);
       a(0) = 1;
       loop(r, a, c, 0);
   }                                              //> pascal4: (c: Int, r: Int)Int

  def pascal2(c: Int, r:Int) : Int = {
      var size = 0
      if (c > r)
        size = c
      else size = r
      
      /* println( size + "hello") */
      
      val a = Array.ofDim[Int](size+1,size+1)
      
      /*
      for(i <- 0 to size) {
         for(k <- 0 to size)
            print(a(i)(k) + " ")
            
         println()
      }
      */
      
      
      def loop(end:Int, col:Int, row:Int) : Int = {
         if (row == end) {
             if ( (row == 0) || (row == 1) ) {
                1
             } else {
                 
            		 for(i <- 0 to size) {
       				  		for(k <- 0 to size)
            					print(a(i)(k) + " ")
         						println()
     						 }
     						          		
               	 println("col = " + col + ", row = " + row );
               	 
               	 if ( (col == 0 ) || (col == row) ) {
               	    1
               	 } else {
               	     a(col-1)(row-1) + a(col-1)(row)
               	 }
             }
          } else {
            for (i <- 0 to row) {
               for (k <- 0 to i) {
               	  if ( i == k ) {
                	    a(i)(k) = 1
                	} else if ( i == 1 ) {
                  	  a(i)(k) = 1
                  } else {
                  	  a(i)(k) = a(i-1)(k-1) + a(i-1)(k)
                  }
               }
            }
            loop(end, c, row+1)
          }
      }
      
      loop(r,c,0)
  }                                               //> pascal2: (c: Int, r: Int)Int
  
  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
      val a = Array.ofDim[Int](c, r)
      /* def loop */
      
    	if (r == 0) {
      	1
    	} else if (r == c) {
      	1
    	} else {
    	  pascal(c-1, r-1) + pascal(c-1, r)
    	}
  }                                               //> pascal: (c: Int, r: Int)Int
  
  def pascal3(c: Int, r: Int): Int = {
    /*@tailrec*/
    def pascalAcc(c: Int, r: Int, acc: List[Int]): List[Int] = {
       if (r == 0) acc
       else pascalAcc(c, r - 1,
       // from let's say 1 3 3 1 builds 0 1 3 3 1 0 , takes only the
       // subset that matters (if asking for col c, no cols after c are
       // used) and uses sliding to build (0 1) (1 3) (3 3) etc.
       (0 +: acc :+ 0).take(c + 2)
         .sliding(2, 1).map { x => x.reduce(_ + _) }.toList)
    }
  
    if (c == 0 || c == r) 1
    else pascalAcc(c, r, List(1))(c)
  }                                               //> pascal3: (c: Int, r: Int)Int

}