object newtonSqrt {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(69); 
  
  
  println("Welcome to the Scala worksheet");$skip(46); 
		
	def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(331); 
		
		def sqrt(x: Double) = {
		  
	  	def sqrtIter(guess: Double): Double =
	  			if (isGoodEnough(guess) ) guess
	  			else sqrtIter(improve(guess))
	  		
	  	def isGoodEnough(guess: Double) =
	      abs(guess * guess - x) / x < 0.001
	  
	 	  def improve(guess: Double) =
	  	  (guess + x / guess) / 2

     	sqrtIter(1.0)
    };System.out.println("""sqrt: (x: Double)Double""");$skip(17); val res$0 = 
    
    sqrt(9);System.out.println("""res0: Double = """ + $show(res$0));$skip(18); val res$1 = 
    
    sqrt(16);System.out.println("""res1: Double = """ + $show(res$1));$skip(21); val res$2 = 
    
    sqrt(0.001);System.out.println("""res2: Double = """ + $show(res$2));$skip(19); 
    
    val x = 0;System.out.println("""x  : Int = """ + $show(x ));$skip(26); 
    def f(y: Int) = y + 1;System.out.println("""f: (y: Int)Int""");$skip(58); 
    val result = {
    	val x = f(3)
    	x * x
    } + x;System.out.println("""result  : Int = """ + $show(result ))}
}
