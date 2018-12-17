package Week1

object collection2 {
  println("Welcome to the Scala worksheet")
  
  ///// Example 5 Map / flatMap
  val chars = 'a' to 'z'
	val perms = chars flatMap { a =>
  	chars flatMap { b =>
    	if (a != b) Seq("%c%c".format(a, b))
    	else Seq()
  	}
	}
  
  Seq(1,2,3,4) flatMap { x =>
      Seq(x, -x)
  }
  
  Seq(1,2,3,4) map { x =>
        Seq(x, -x)
  }
  
  Seq(1,2,3,4) flatMap { x =>
    if (x%2 == 0) Seq(x)
    else Seq()
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