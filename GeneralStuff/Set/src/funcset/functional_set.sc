package funcset

object functional_set {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /*
     def set(i: Int): Set = n => n == i
		 def contains(s: Set, i: Int) = s(i)
     def union(a: Set, b: Set): Set = i => a(i) || b(i)
     def intersect(a: Set, b: Set): Set = i => a(i) && b(i)
     def minus(a: Set, b: Set): Set = i => a(i) && !b(i)
     def subset(a: Set, b: Set) = Int.MinValue to Int.MaxValue filter(a) forall(b)
  */
  
  type Set = Int => Boolean
  
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: funcset.functional_set.Set, elem: Int)Boolean
  def singletonSet(elem: Int): Set = set => set == elem
                                                  //> singletonSet: (elem: Int)funcset.functional_set.Set
                                                  
  def union(s: Set, t: Set): Set = i => s(i) || t(i)
                                                  //> union: (s: funcset.functional_set.Set, t: funcset.functional_set.Set)funcset
                                                  //| .functional_set.Set
                                                  
  val why = singletonSet(3)                       //> why  : funcset.functional_set.Set = <function1>
  contains(why, 3)                                //> res0: Boolean = true
  
  val k = singletonSet(1)                         //> k  : funcset.functional_set.Set = <function1>
  val l = singletonSet(2)                         //> l  : funcset.functional_set.Set = <function1>
  val u = union(k, l)                             //> u  : funcset.functional_set.Set = <function1>
  
  contains(u, 1)                                  //> res1: Boolean = true
  contains(u, 2)                                  //> res2: Boolean = true
                                                  
  def intersect(s: Set, t: Set): Set = i => s(i) && t(i)
                                                  //> intersect: (s: funcset.functional_set.Set, t: funcset.functional_set.Set)fun
                                                  //| cset.functional_set.Set
  val z = intersect(k,l)                          //> z  : funcset.functional_set.Set = <function1>
  
  contains(z, 1)                                  //> res3: Boolean = false
  contains(z, 2)                                  //> res4: Boolean = false
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = i => s(i) && !t(i)
                                                  //> diff: (s: funcset.functional_set.Set, t: funcset.functional_set.Set)funcset
                                                  //| .functional_set.Set
                                                  
    val d = diff(k,l)                             //> d  : funcset.functional_set.Set = <function1>
    
    contains(d, 1)                                //> res5: Boolean = true
    contains(d, 2)                                //> res6: Boolean = false
   
   //def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = intersect(s,p)
                                                  //> filter: (s: funcset.functional_set.Set, p: Int => Boolean)funcset.functiona
                                                  //| l_set.Set
                                                  
    val f = union(k,l)                            //> f  : funcset.functional_set.Set = <function1>
    val g = filter(f,k)                           //> g  : funcset.functional_set.Set = <function1>
    contains(g, 1)                                //> res7: Boolean = true
    contains(g, 2)                                //> res8: Boolean = false
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
    val bound = 1000                              //> bound  : Int = 1000


/*
def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !p(a)) false
      else iter(a+1)
    }
    iter(-bound)
  }
*/
  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
    def forall(s: Set, p: Int => Boolean): Boolean = {
      def iter(a: Int): Boolean = {
         if (a > bound) true
         else if (contains(s, a) && !p(a)) false
         else iter(a + 1)
      }
      iter(-bound)
  }                                               //> forall: (s: funcset.functional_set.Set, p: Int => Boolean)Boolean
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
   
   /*
   def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))
   */
  def exists(s: Set, p: Int => Boolean): Boolean = {
       def loop(a: Int): Boolean = {
           if (a > bound) {
              false
           } else if ( contains(s, a) && p(a) ) {
              true
           } else {
           	  loop(a + 1)
           }
       }
       
       loop(-bound)
  }                                               //> exists: (s: funcset.functional_set.Set, p: Int => Boolean)Boolean
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
   /*
   def map(s: Set, f: Int => Int): Set = {
    def iterate(s:Set, accumulateSet: Set, a:Int): Set = {
      if (a > bound) accumulateSet
      else if (contains(s, a)) iterate(s, union(accumulateSet, x=>f(a) == x), a+1)
      else iterate(s, accumulateSet, a+1)
    }
    iterate(s, x=>false, -3)
  }
   */
  def map(s: Set, f: Int => Int): Set = {
      def loop(s: Set, cacheSet: Set, a: Int): Set = {
          if ( a > bound ) {
             cacheSet
          } else if ( contains(s, a)) {
             loop(s, union(cacheSet, x => f(a) == x), a+1)
          } else {
             loop(s, cacheSet, a+1)
          }
      }
      
      loop(s, x => false, -bound)
  }                                               //> map: (s: funcset.functional_set.Set, f: Int => Int)funcset.functional_set.S
                                                  //| et
  
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: funcset.functional_set.Set)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: funcset.functional_set.Set)Unit
}