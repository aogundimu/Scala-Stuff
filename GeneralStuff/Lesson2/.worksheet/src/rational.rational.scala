package rational

object rational {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  val x = new Rational(1,3);System.out.println("""x  : rational.rational.Rational = """ + $show(x ));$skip(28); 
  val y = new Rational(5,7);System.out.println("""y  : rational.rational.Rational = """ + $show(y ));$skip(28); 
  val z = new Rational(3,2);System.out.println("""z  : rational.rational.Rational = """ + $show(z ));$skip(13); val res$0 = 
  
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(8); val res$2 = 
  x.neg;System.out.println("""res2: rational.rational.Rational = """ + $show(res$2));$skip(11); 
  x.sub(y)}

  class Rational(x: Int, y:Int) {
     def numer = x
     def denom = y
     
     def add(that: Rational) {
     	  new Rational(
     	     numer * that.denom + that.numer * denom,
     	     denom * that.denom )
     }
     
     def neg: Rational = new Rational(-numer, denom);
     
     def sub(that: Rational) = add(that.neg);
             
     override def toString = numer + "/" + denom;
  }
  
}
