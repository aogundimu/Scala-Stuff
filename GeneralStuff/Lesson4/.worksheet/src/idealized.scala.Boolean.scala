package idealized.scala

object Boolean {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 
  println("Welcome to the Scala worksheet")}
}


abstract class Boolean {

   def ifThenElse[T](t: => T, e: => T): T
   
   def && (x: => Boolean): Boolean = ifThenElse(x, false)
   
   def || (x: => Boolean): Boolean = ifThenElse(true, x)
   
   def unary_!: Boolean            = ifThenElse(false, true)
   
   def == (x: Boolean): Boolean    = ifThenElse(x, x.unary_!)
   
   def != (x: Boolean): Boolean    = ifThenElse(x.unary_!, x)
}

object true extends Boolean {
  def ifThenElse[T](t: => T, e: => T) = t
}

object false extends Boolean {
  def ifThenElse[T](t: => T, e: => T) = e
}
