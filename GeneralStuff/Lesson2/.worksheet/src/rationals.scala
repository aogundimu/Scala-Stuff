object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(29); 
   val x = new Rational(1,3);System.out.println("""x  : Rational = """ + $show(x ));$skip(29); 
   val y = new Rational(5,7);System.out.println("""y  : Rational = """ + $show(y ));$skip(29); 
   val z = new Rational(3,2);System.out.println("""z  : Rational = """ + $show(z ));$skip(14); val res$0 = 
  
   x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(11); val res$1 = 
   x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(9); val res$2 = 
   x.neg;System.out.println("""res2: Rational = """ + $show(res$2));$skip(9); val res$3 = 
   y.neg;System.out.println("""res3: Rational = """ + $show(res$3));$skip(19); val res$4 = 
   x.sub(y).sub(z);System.out.println("""res4: Rational = """ + $show(res$4));$skip(12); val res$5 = 
   y.sub(z);System.out.println("""res5: Rational = """ + $show(res$5));$skip(12); val res$6 = 
   y.add(y);System.out.println("""res6: Rational = """ + $show(res$6));$skip(13); val res$7 = 
   x.less(y);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(12); val res$8 = 
   x.max(y);System.out.println("""res8: Rational = """ + $show(res$8));$skip(19); val res$9 = 
   new Rational(2);System.out.println("""res9: Rational = """ + $show(res$9))}
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
