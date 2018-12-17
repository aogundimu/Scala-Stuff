object monoid {
    println("Welcome to the Scala worksheet")     //> Welcome to the Scala worksheet
    
    trait Monoid[A] {
    	def op(a1: A, a2: A): A
    	def zero: A
    }
    
    // A String monoid
    val stringMonoid = new Monoid[String] {
    	def op(a1: String, a2: String) = a1 + a2
    	val zero = ""
    }                                             //> stringMonoid  : monoid.Monoid[String]{val zero: String} = monoid$$anonfun$ma
                                                  //| in$1$$anon$1@3f3afe78
    
    // A list monoid
    def listMonoid[A] = new Monoid[List[A]] {
    	def op(a1: List[A], a2: List[A]) = a1 ++ a2
    	val zero = Nil
    }                                             //> listMonoid: [A]=> monoid.Monoid[List[A]]{val zero: scala.collection.immutabl
                                                  //| e.Nil.type}
    
    val intAddition: Monoid[Int] = new Monoid[Int] {
    	def op(a1: Int, a2: Int) = a1 + a2
    	val zero = 0
    }                                             //> intAddition  : monoid.Monoid[Int] = monoid$$anonfun$main$1$$anon$3@7f63425a
    
    val intMultiplication: Monoid[Int] = new Monoid[Int] {
    	def op(a1: Int, a2: Int) = a1 * a2
    	val zero = 1
    }                                             //> intMultiplication  : monoid.Monoid[Int] = monoid$$anonfun$main$1$$anon$4@36d
                                                  //| 64342
    
    val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
    	def op(a1: Boolean, a2: Boolean) = a1 || a2
    	val zero = false
    }                                             //> booleanOr  : monoid.Monoid[Boolean] = monoid$$anonfun$main$1$$anon$5@39ba5a1
                                                  //| 4
    
    val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
    	def op(a1: Boolean, a2: Boolean) = a1 && a2
    	val zero = true
    }                                             //> booleanAnd  : monoid.Monoid[Boolean] = monoid$$anonfun$main$1$$anon$6@511baa
                                                  //| 65
    
    // How do I use there Monoids?
    val words = List("Hic", "Est", "Index")       //> words  : List[String] = List(Hic, Est, Index)
    val s = words.foldRight(stringMonoid.zero)(stringMonoid.op)
                                                  //> s  : String = HicEstIndex
    
      
}