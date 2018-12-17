package Week1

object queries_with_for {                         //> Welcome to the Scala worksheet
  
  	case class Book(title: String, authors:List[String])
  	
  	val books = List(
  	
  	   Book(
  	       title = "Structure and Interpretation of Computer Programs",
  	       authors = List("Abelson, Harald", "Sussman, Gerald J.") ),
  	     
  	   Book(
  	     title = "Introduction to Functional Programming",
  	     authors = List("Bird, Richard", "Wadler, Phil") ),
  	     
  	   Book(
  	     title = "Effective Java",
  	     authors = List("Bloch, Joshua") ),
  	     
  	   Book(
  	     title = "Effective Java 2",
  	     authors = List("Bloch, Joshua") ),
  	     
  	   Book(
  	     title = "Java Puzzlers",
  	     authors = List("Bloch, Joshua", "Gafter, Neal")),
  	     
  	   Book(
  	     title = "Programming in Scala",
  	     authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill") )
  	)                                         //> books  : List[Week1.queries_with_for.Book] = List(Book(Structure and Interpr
                                                  //| etation of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)), Boo
                                                  //| k(Introduction to Functional Programming,List(Bird, Richard, Wadler, Phil)),
                                                  //|  Book(Effective Java,List(Bloch, Joshua)), Book(Effective Java 2,List(Bloch,
                                                  //|  Joshua)), Book(Java Puzzlers,List(Bloch, Joshua, Gafter, Neal)), Book(Progr
                                                  //| amming in Scala,List(Odersky, Martin, Spoon, Lex, Venners, Bill)))
  
  for (b <- books; a <- b.authors if a startsWith "Bloch,") yield b.title
                                                  //> res0: List[String] = List(Effective Java, Effective Java 2, Java Puzzlers)
   /*
  { for {
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    } yield a1
  }.distinct
  */
  for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
  } yield a1                                      //> res1: List[String] = List(Bloch, Joshua, Bloch, Joshua, Bloch, Joshua)
  
 // books flatMap(b => 
      
}