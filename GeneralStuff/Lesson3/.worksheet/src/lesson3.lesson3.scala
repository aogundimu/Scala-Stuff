package lesson3

import list._

object lesson3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala worksheet");$skip(49); 
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : lesson3.NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : lesson3.IntSet = """ + $show(t2 ));$skip(63); 
  
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)list.Cons[T]""");$skip(32); 
  
  val si = singleton[Int](1);System.out.println("""si  : list.Cons[Int] = """ + $show(si ));$skip(37); 
  val sb = singleton[Boolean](false);System.out.println("""sb  : list.Cons[Boolean] = """ + $show(sb ));$skip(28); 
  
  val si1 = singleton(1);System.out.println("""si1  : list.Cons[Int] = """ + $show(si1 ));$skip(28); 
  val sb1 = singleton(true);System.out.println("""sb1  : list.Cons[Boolean] = """ + $show(sb1 ));$skip(190); 
  
  
  def nth[T](n: Int, list: List[T]): T = {
     if (list.isEmpty)
        throw new IndexOutOfBoundsException
     else if (n == 0)
        list.head
     else nth(n-1, list.tail)
  };System.out.println("""nth: [T](n: Int, list: list.List[T])T""");$skip(60); 
  
  val l = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""l  : list.Cons[Int] = """ + $show(l ));$skip(12); val res$0 = 
  nth(2, l);System.out.println("""res0: Int = """ + $show(res$0));$skip(11); val res$1 = 
  nth(5,l);System.out.println("""res1: Int = """ + $show(res$1))}
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

/*
  It is more appropriate to have a single instance of the Empty class, this could be
  implemented as a Singleton. To do so, change the "class" keyword to "object"
*/
//object Empty extends IntSet
class Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	def union(other: IntSet) = other
	override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet ) extends IntSet {
  def contains(x: Int): Boolean =
     if (x < elem) left contains x
     else if (x > elem) right contains x
     else true

  def incl(x: Int): IntSet =
     if (x < elem) new NonEmpty(elem, left incl x, right)
     else if (x > elem) new NonEmpty(elem, left, right incl x)
     else this
    
  def union(other: IntSet): IntSet =
     ((left union right) union other) incl elem
  override def toString = "{" + left + elem + right + "}"
}

abstract class Base {
	 def foo = 1
	 def bar: Int
}

class Sub extends Base {
	 override def foo = 2 /* override is needed */
	 def bar = 3 /* override is optional since function was not implemented in base class */
}
