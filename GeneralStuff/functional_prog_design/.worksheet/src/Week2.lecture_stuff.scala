package Week2

object lecture_stuff {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet")}
  
  abstract class IntSet {
  	def incl(x: Int):IntSet
  	def contains(x: Int):Boolean
  }
  
  object Empty extends IntSet {
  	def contains(x: Int): Boolean = false
  	def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
  }
  
  case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  	
  	def contains(x: Int): Boolean =
    	if (x < elem) left contains x
    	else if (x > elem) right contains x
    	else true
  
  	def incl(x: Int): IntSet =
    	if (x < elem) NonEmpty(elem, left incl x, right)
    	else if (x > elem) NonEmpty(elem, left, right incl x)
    	else this
  }
}
