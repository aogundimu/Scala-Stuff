package week4

abstract class Nat {  
    def isZero: Boolean
    def predecessor: Nat
    // def successor: Nat
    def successor = new Succ(this)
    def +(that: Nat): Nat
    def -(that: Nat): Nat  
}

object Zero extends Nat {
   def isZero = true
   def predecessor = throw new Error("0.predecessor")  
   def +(that: Nat) = that
   def -(that: Nat) = if (that.isZero) this else throw new Error("negative number")
}

class Succ(n: Nat) extends Nat { 
  def isZero = false
  def predecessor = n
  //def successor = new Succ(this)
  def +(that: Nat) = new Succ(n + that)
  def -(that: Nat) = if (that.isZero) this else n - that.predecessor
}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
   def isEmpty: Boolean = true
}

class Nil[T] extends List[T] {
   def isEmpty: Boolean = true
   def head: Nothing = throw new NoSuchElementException("Nil.head")
   def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
