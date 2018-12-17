object map_polynomials {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet")

  class Poly(val terms0: Map[Int, Double]) {
    // sequence -> map
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	val terms = terms0 withDefaultValue 0.0
  	
  	//def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	// The same implementation using foldLeft
  	def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  	
  	def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
  	    val (exp, coeff) = term
  	    terms + (exp -> (coeff + terms(exp)))
  	}
  	
  	def adjust(term: (Int, Double)): (Int, Double) = {
  	   val (exp, coeff) = term
  	   exp -> (coeff + terms(exp))
  	   
  	   //terms get exp match {
  	   //	 case Some(coeff1) => exp -> (coeff + coeff1)
  	   // case None => exp -> coeff
  	   // }
  	}
  	
  	override def toString =
  	   (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^"+exp) mkString " + "
  };$skip(984); 
  
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p1  : map_polynomials.Poly = """ + $show(p1 ));$skip(45); 
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0));System.out.println("""p2  : map_polynomials.Poly = """ + $show(p2 ));$skip(13); val res$0 = 
  
  p1 + p2;System.out.println("""res0: map_polynomials.Poly = """ + $show(res$0));$skip(17); val res$1 = 
  
  p1.terms(7);System.out.println("""res1: Double = """ + $show(res$1))}
}
