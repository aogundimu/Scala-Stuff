package ChapterSix

object chapter_six {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet")
  
  class Rational( n: Int, d: Int) {
       
       require( d != 0)
       
       val numer: Int = n
       
       val denom: Int = d
       
       // An auxiliary constructor
       def this( n: Int) = this( n, 1)

       override def toString = numer + "/" + denom
       
       def add( that: Rational): Rational =
          new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
   };$skip(532); 
   
   // This results in IllegalArgumentException
   //val kk = new Rational(3,0)
   val oneHalf = new Rational(1,2);System.out.println("""oneHalf  : ChapterSix.chapter_six.Rational = """ + $show(oneHalf ));$skip(21); val res$0 = 
   
   oneHalf.denom;System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
   oneHalf.numer;System.out.println("""res1: Int = """ + $show(res$1))}
}
