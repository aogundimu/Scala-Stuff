package balanced_parenthesis

import scala.collection.immutable.Stack

object balanced {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  println( balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList) )
                                                  //> false
  println( balance("(if (zero? x) max (/ 1 x))".toList) )
                                                  //> false
   println( balance(":-)".toList) )               //> false
   
   println( balance("())(".toList) )              //> false
   
   println( balance( "()".toList) )               //> false
  
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
  }                                               //> balance: (chars: List[Char])Boolean
}