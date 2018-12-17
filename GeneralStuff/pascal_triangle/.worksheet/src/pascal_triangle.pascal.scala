package pascal_triangle

object pascal {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(76); 

    /* print(pascal4(7,14))  */
    
    
    println("Pascal's Triangle");$skip(116); 
    for (row <- 0 to 15) {
      for (col <- 0 to row)
        print(pascal4(col, row) + " ")
      println()
    };$skip(754); 
    
    
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
   };System.out.println("""pascal4: (c: Int, r: Int)Int""");$skip(1447); 

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
  };System.out.println("""pascal2: (c: Int, r: Int)Int""");$skip(265); 
  
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
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(559); 
  
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
  };System.out.println("""pascal3: (c: Int, r: Int)Int""")}

}
