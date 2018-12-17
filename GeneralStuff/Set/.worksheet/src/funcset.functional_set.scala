package funcset

object functional_set {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet")
  
  /*
     def set(i: Int): Set = n => n == i
		 def contains(s: Set, i: Int) = s(i)
     def union(a: Set, b: Set): Set = i => a(i) || b(i)
     def intersect(a: Set, b: Set): Set = i => a(i) && b(i)
     def minus(a: Set, b: Set): Set = i => a(i) && !b(i)
     def subset(a: Set, b: Set) = Int.MinValue to Int.MaxValue filter(a) forall(b)
  */
  
  type Set = Int => Boolean;$skip(435); 
  
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: funcset.functional_set.Set, elem: Int)Boolean""");$skip(56); 
  def singletonSet(elem: Int): Set = set => set == elem;System.out.println("""singletonSet: (elem: Int)funcset.functional_set.Set""");$skip(104); 
                                                  
  def union(s: Set, t: Set): Set = i => s(i) || t(i);System.out.println("""union: (s: funcset.functional_set.Set, t: funcset.functional_set.Set)funcset.functional_set.Set""");$skip(79); 
                                                  
  val why = singletonSet(3);System.out.println("""why  : funcset.functional_set.Set = """ + $show(why ));$skip(19); val res$0 = 
  contains(why, 3);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(29); 
  
  val k = singletonSet(1);System.out.println("""k  : funcset.functional_set.Set = """ + $show(k ));$skip(26); 
  val l = singletonSet(2);System.out.println("""l  : funcset.functional_set.Set = """ + $show(l ));$skip(22); 
  val u = union(k, l);System.out.println("""u  : funcset.functional_set.Set = """ + $show(u ));$skip(20); val res$1 = 
  
  contains(u, 1);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(17); val res$2 = 
  contains(u, 2);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(108); 
                                                  
  def intersect(s: Set, t: Set): Set = i => s(i) && t(i);System.out.println("""intersect: (s: funcset.functional_set.Set, t: funcset.functional_set.Set)funcset.functional_set.Set""");$skip(25); 
  val z = intersect(k,l);System.out.println("""z  : funcset.functional_set.Set = """ + $show(z ));$skip(20); val res$3 = 
  
  contains(z, 1);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(17); val res$4 = 
  contains(z, 2);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(178); 
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = i => s(i) && !t(i);System.out.println("""diff: (s: funcset.functional_set.Set, t: funcset.functional_set.Set)funcset.functional_set.Set""");$skip(73); 
                                                  
    val d = diff(k,l);System.out.println("""d  : funcset.functional_set.Set = """ + $show(d ));$skip(24); val res$5 = 
    
    contains(d, 1);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(19); val res$6 = 
    contains(d, 2);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(198); 
   
   //def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = intersect(s,p);System.out.println("""filter: (s: funcset.functional_set.Set, p: Int => Boolean)funcset.functional_set.Set""");$skip(74); 
                                                  
    val f = union(k,l);System.out.println("""f  : funcset.functional_set.Set = """ + $show(f ));$skip(24); 
    val g = filter(f,k);System.out.println("""g  : funcset.functional_set.Set = """ + $show(g ));$skip(19); val res$7 = 
    contains(g, 1);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(19); val res$8 = 
    contains(g, 2);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(93); 
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
    val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(517); 


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
  };System.out.println("""forall: (s: funcset.functional_set.Set, p: Int => Boolean)Boolean""");$skip(501); 
  
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
  };System.out.println("""exists: (s: funcset.functional_set.Set, p: Int => Boolean)Boolean""");$skip(763); 
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
  };System.out.println("""map: (s: funcset.functional_set.Set, f: Int => Int)funcset.functional_set.Set""");$skip(187); 
  
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  };System.out.println("""toString: (s: funcset.functional_set.Set)String""");$skip(117); 

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  };System.out.println("""printSet: (s: funcset.functional_set.Set)Unit""")}
}
