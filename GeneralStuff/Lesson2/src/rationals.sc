object rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
   val x = new Rational(1,3)                      //> x  : Rational = 1/3
   val y = new Rational(5,7)                      //> y  : Rational = 5/7
   val z = new Rational(3,2)                      //> z  : Rational = 3/2
  
   x.numer                                        //> res0: Int = 1
   x.denom                                        //> res1: Int = 3
   x.neg                                          //> res2: Rational = 1/-3
   y.neg                                          //> res3: Rational = 5/-7
   x.sub(y).sub(z)                                //> res4: Rational = -79/42
   y.sub(z)                                       //> res5: Rational = -11/14
   y.add(y)                                       //> res6: Rational = 10/7
   x.less(y)                                      //> res7: Boolean = true
   x.max(y)                                       //> res8: Rational = 5/7
   new Rational(2)                                //> res9: Rational = 2/1
}

class Rational(x: Int, y:Int) {
     
     /* this will be executed whenever an object is constructed */
     require(y != 0, "denominator must be nonzero")

     /* This is another constructor */
     def this(x: Int) = this(x,1)
     
     private def gcd(a: Int, b:Int): Int = if(b == 0) a else gcd(b, a % b)
     private val g = gcd(x, y)
     def numer = x / g
     def denom = y / g
     
     def add(that: Rational): Rational = {
     	  new Rational(
     	     numer * that.denom + that.numer * denom,
     	     denom * that.denom )
     }
     
     def less(that: Rational) = numer * that.denom < that.numer * denom
     
     def neg: Rational = new Rational(-numer, denom)
     
     def sub(that: Rational) = add(that.neg)
     
     def max(that: Rational) = if (this.less(that)) that else this
             
     override def toString = numer + "/" + denom
}