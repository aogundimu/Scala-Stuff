package ChapterSix

object chapter_six {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class Rational( n: Int, d: Int) {
       
       require( d != 0)
       
       val numer: Int = n
       
       val denom: Int = d
       
       // An auxiliary constructor
       def this( n: Int) = this( n, 1)

       override def toString = numer + "/" + denom
       
       def add( that: Rational): Rational =
          new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
   }
   
   // This results in IllegalArgumentException
   //val kk = new Rational(3,0) 
   val oneHalf = new Rational(1,2)                //> oneHalf  : ChapterSix.chapter_six.Rational = 1/2
   
   oneHalf.denom                                  //> res0: Int = 2
   oneHalf.numer                                  //> res1: Int = 1
}