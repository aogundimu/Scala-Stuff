object newtonSqrt {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
		
		def sqrt(x: Double) = {
		
	  	def abs(x: Double) = if (x < 0) -x else x
	  
	  	def sqrtIter(guess: Double, x: Double): Double =
	  			if (isGoodEnough(guess, x) ) guess
	  			else sqrtIter(improve(guess,x), x)
	  		
	  	def isGoodEnough(guess: Double, x: Double) =
	      abs(guess * guess - x) / x < 0.001
	  
	 	  def improve(guess: Double, x: Double) =
	  	  (guess + x / guess) / 2

     	sqrtIter(1.0, x)
    }                                             //> sqrt: (x: Double)Double
    
    sqrt(9)                                       //> res0: Double = 3.00009155413138
    
    sqrt(16)                                      //> res1: Double = 4.000000636692939
    
    sqrt(0.001)                                   //> res2: Double = 0.03162278245070105
    
    val x = 0                                     //> x  : Int = 0
    def f(y: Int) = y + 1                         //> f: (y: Int)Int
    val result = {
    	val x = f(3)
    	x * x
    } + x                                         //> result  : Int = 16
}