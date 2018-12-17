object monoid {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
    println("Welcome to the Scala worksheet")
    
    trait Monoid[A] {
    	def op(a1: A, a2: A): A
    	def zero: A
    };$skip(222); 
    
    // A String monoid
    val stringMonoid = new Monoid[String] {
    	def op(a1: String, a2: String) = a1 + a2
    	val zero = ""
    };System.out.println("""stringMonoid  : monoid.Monoid[String]{val zero: String} = """ + $show(stringMonoid ));$skip(147); 
    
    // A list monoid
    def listMonoid[A] = new Monoid[List[A]] {
    	def op(a1: List[A], a2: List[A]) = a1 ++ a2
    	val zero = Nil
    };System.out.println("""listMonoid: [A]=> monoid.Monoid[List[A]]{val zero: scala.collection.immutable.Nil.type}""");$skip(122); 
    
    val intAddition: Monoid[Int] = new Monoid[Int] {
    	def op(a1: Int, a2: Int) = a1 + a2
    	val zero = 0
    };System.out.println("""intAddition  : monoid.Monoid[Int] = """ + $show(intAddition ));$skip(128); 
    
    val intMultiplication: Monoid[Int] = new Monoid[Int] {
    	def op(a1: Int, a2: Int) = a1 * a2
    	val zero = 1
    };System.out.println("""intMultiplication  : monoid.Monoid[Int] = """ + $show(intMultiplication ));$skip(141); 
    
    val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
    	def op(a1: Boolean, a2: Boolean) = a1 || a2
    	val zero = false
    };System.out.println("""booleanOr  : monoid.Monoid[Boolean] = """ + $show(booleanOr ));$skip(141); 
    
    val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
    	def op(a1: Boolean, a2: Boolean) = a1 && a2
    	val zero = true
    };System.out.println("""booleanAnd  : monoid.Monoid[Boolean] = """ + $show(booleanAnd ));$skip(84); 
    
    // How do I use there Monoids?
    val words = List("Hic", "Est", "Index");System.out.println("""words  : List[String] = """ + $show(words ));$skip(64); 
    val s = words.foldRight(stringMonoid.zero)(stringMonoid.op);System.out.println("""s  : String = """ + $show(s ))}
    
      
}
