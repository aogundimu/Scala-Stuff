package balanced_parenthesis

import scala.collection.immutable.Stack

object balanced {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(132); 
  println("Welcome to the Scala worksheet");$skip(100); 
  
  println( balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList) );$skip(58); 
  println( balance("(if (zero? x) max (/ 1 x))".toList) );$skip(36); 
   println( balance(":-)".toList) );$skip(41); 
   
   println( balance("())(".toList) );$skip(40); 
   
   println( balance( "()".toList) );$skip(821); 
  
  def balance(chars: List[Char]): Boolean = {
  
     def loop(chars: List[Char], stack: Stack[Char] ): Boolean = {
     
         if ( chars.isEmpty ) {
             stack.isEmpty
         } else {
             val c = chars.head
             if ( c == '(' ) {
                stack.push(c)
                loop(chars.tail, stack)
             } else if (c == ')') {
                if ( stack.isEmpty ) {
                  false
                } else {
                  val s = stack.pop
                	if ( s == '(' ) {
                  	 loop(chars.tail, stack)
               	  } else {
                     false
                  }
                }
             } else {
                loop(chars.tail, stack)
             }
         }
     }

     val stack = Stack[Char]()
     loop(chars, stack)
  };System.out.println("""balance: (chars: List[Char])Boolean""")}
}
