package Week1

object queries_with_for {
  
  	case class Book(title: String, authors:List[String]);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(869); 
  	
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
  	);System.out.println("""books  : List[Week1.queries_with_for.Book] = """ + $show(books ));$skip(77); val res$0 = 
  
  for (b <- books; a <- b.authors if a startsWith "Bloch,") yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(322); val res$1 = 
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
  } yield a1;System.out.println("""res1: List[String] = """ + $show(res$1))}
  
 // books flatMap(b =>
      
}
