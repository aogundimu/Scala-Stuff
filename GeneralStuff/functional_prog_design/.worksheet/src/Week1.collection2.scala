package Week1

object collection2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(60); 
  
  ///// Example 5 Map / flatMap
  val chars = 'a' to 'z';System.out.println("""chars  : scala.collection.immutable.NumericRange.Inclusive[Char] = """ + $show(chars ));$skip(121); 
	val perms = chars flatMap { a =>
  	chars flatMap { b =>
    	if (a != b) Seq("%c%c".format(a, b))
    	else Seq()
  	}
	};System.out.println("""perms  : scala.collection.immutable.IndexedSeq[String] = """ + $show(perms ));$skip(53); val res$0 = 
  
  Seq(1,2,3,4) flatMap { x =>
      Seq(x, -x)
  };System.out.println("""res0: Seq[Int] = """ + $show(res$0));$skip(52); val res$1 = 
  
  Seq(1,2,3,4) map { x =>
        Seq(x, -x)
  };System.out.println("""res1: Seq[Seq[Int]] = """ + $show(res$1));$skip(77); val res$2 = 
  
  Seq(1,2,3,4) flatMap { x =>
    if (x%2 == 0) Seq(x)
    else Seq();System.out.println("""res2: Seq[Int] = """ + $show(res$2))}
  }
  
  /*
  val chars = 'a' to 'z'
    val perms = chars flatMap { a =>
      chars flatMap { b =>
      if (a != b) Seq("%c%c".format(a, b))
      else Seq()
    }
  }
  */
}
