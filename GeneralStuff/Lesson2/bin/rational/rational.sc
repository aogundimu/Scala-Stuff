package rationals

object rationals {

   val x = new Rational(1,3)                      //> x  : rationals.Rational = 1/3
   val y = new Rational(5,7)                      //> y  : rationals.Rational = 5/7
   val z = new Rational(3,2)                      //> z  : rationals.Rational = 3/2
  
   x.numer                                        //> res0: Int = 1
   x.denom                                        //> res1: Int = 3
   x.neg                                          //> res2: rationals.Rational = -1/3
}

class Rational(x: Int, y:Int) {
     def numer = x
     def denom = y
     
     def add(that: Rational) {
     	  new Rational(
     	     numer * that.denom + that.numer * denom,
     	     denom * that.denom )
     }
     
     def neg: Rational = new Rational(-numer, denom)
     
     def subb(that: Rational) = add(that.neg)
             
     override def toString = numer + "/" + denom
}