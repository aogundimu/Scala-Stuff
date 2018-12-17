package Week1

object books {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet")
 
  case class Book(title: String, authors: List[String]);$skip(873); 
 
  val books: List[Book] = List(
		  Book(title = "Structure and Interpretation of Computer Programs",
     		   authors = List("Abelson, Harald", "Sussman, Gerald J.")),
     	Book(title = "Structure and Interpretation of Computer Programs",
     	     authors = List("Abelson, Harald", "Sussman, Gerald J.")),
	    Book(title = "Introduction to Functional Programming",
           authors = List("Bird, Richard", "Waddler, Phil")),
      Book(title = "Effective Java",
           authors = List("Bloch, Joshua")),
      Book(title = "Effective Java 2",
           authors = List("Bloch, Joshua")),
    	Book(title = "Java Puzzlers",
    	     authors = List("Bloch, Joshua", "Gafter, Neal")),
    	Book(title = "Programming in Scala",
    	     authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")));System.out.println("""books  : List[Week1.books.Book] = """ + $show(books ));$skip(142); val res$0 = 
	
	    //To find the titles of books whose author’s name is “Bird”:
			for (b <- books; a <- b.authors if a startsWith "Bird,") yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(444); val res$1 = 
			
      // To find all the books which have the word “Program” in the title:
      // This does not like the 0
  		//for (b <- books if b.title indexOf "Program" >= 0) yield b.title
  		
  		// To find the names of all authors who have written at least
  		// two books present in the database.
  		for {
    		b1 <- books
    		b2 <- books
    		if b1 != b2
    			a1 <- b1.authors
    		  a2 <- b2.authors
    		  if a1 == a2
			} yield a1;System.out.println("""res1: List[String] = """ + $show(res$1));$skip(83); val res$2 = 
			
			//
			for (b <- books; a <- b.authors if a startsWith "Bird") yield b.title;System.out.println("""res2: List[String] = """ + $show(res$2));$skip(156); val res$3 = 
			// Translation of the above function using high order functions
			books flatMap(b => b.authors withFilter(a => a startsWith "Bloch") map(y => b.title));System.out.println("""res3: List[String] = """ + $show(res$3))}
			
			
			
			// To find the names of all authors who have written at least two books
			// present in the database without repeating the name twice
  	  /*
  	  for {
 		    b1 <- books
	      b2 <- books
	      if b1.title < b2.title
   	      a1 <- b1.authors
    		  a2 <- b2.authors
        if a1 == a2
		  } yield a1
  		
  		// What about authors who have written more than 3 books?
  		// Solution: We must remove duplicate authors who are in the results list
  		// twice. This is achieved using the distinct method on sequences:
      { for {
           b1 <- books
           b2 <- books
           if b1.title < b2.title
           a1 <- b1.authors
           a2 <- b2.authors
           if a1 == a2
        } yield a1
      }.distinct
      
      
     // Better alternative: Compute with sets instead of sequences:
     val bookSet = books.toSet
     for {
       b1 <- bookSet
       b2 <- bookSet
       if b1 != b2
         a1 <- b1.authors
         a2 <- b2.authors
       if a1 == a2
     } yield a1
   */
}
