package lesson3

import list._

object lesson3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : lesson3.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : lesson3.IntSet = {.3{.4.}}
  
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)list.Cons[T]
  
  val si = singleton[Int](1)                      //> si  : list.Cons[Int] = list.Cons@22f71333
  val sb = singleton[Boolean](false)              //> sb  : list.Cons[Boolean] = list.Cons@13969fbe
  
  val si1 = singleton(1)                          //> si1  : list.Cons[Int] = list.Cons@6aaa5eb0
  val sb1 = singleton(true)                       //> sb1  : list.Cons[Boolean] = list.Cons@3498ed
  
  
  def nth[T](n: Int, list: List[T]): T = {
     if (list.isEmpty)
        throw new IndexOutOfBoundsException
     else if (n == 0)
        list.head
     else nth(n-1, list.tail)
  }                                               //> nth: [T](n: Int, list: list.List[T])T
  
  val l = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> l  : list.Cons[Int] = list.Cons@1a407d53
  nth(2, l)                                       //> res0: Int = 3
  nth(5,l)                                        //> java.lang.IndexOutOfBoundsException
                                                  //| 	at lesson3.lesson3$$anonfun$main$1.nth$1(lesson3.lesson3.scala:21)
                                                  //| 	at lesson3.lesson3$$anonfun$main$1.apply$mcV$sp(lesson3.lesson3.scala:29
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at lesson3.lesson3$.main(lesson3.lesson3.scala:5)
                                                  //| 	at lesson3.lesson3.main(lesson3.lesson3.scala)
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