package ChapterOne

object chapter_one {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  var capital = Map(" US" -> "Washington", "France" -> "Paris")
                                                  //> capital  : scala.collection.immutable.Map[String,String] = Map(" US" -> Wash
                                                  //| ington, France -> Paris)
  capital += ("Japan" -> "Tokyo")
  println( capital("France"))                     //> Paris
  println( capital("Japan"))                      //> Tokyo
  
  def factorial(x: BigInt): BigInt =
     if (x == 0)
       1
     else
       x * factorial(x - 1)                       //> factorial: (x: BigInt)BigInt
       
  factorial(30)                                   //> res0: BigInt = 265252859812191058636308480000000

}