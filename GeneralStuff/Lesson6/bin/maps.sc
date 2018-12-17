package week6

object maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[Char,Int] = Map(I -> 1, V ->
                                                  //|  5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
   capitalOfCountry("US")                         //> res0: String = Washington
   //capitalOfCountry("andorra")
   capitalOfCountry get "andorra"                 //> res1: Option[String] = None
   capitalOfCountry get "US"                      //> res2: Option[String] = Some(Washington)
   
   val cap1 = capitalOfCountry withDefaultValue "<unknown>"
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washington
                                                  //| , Switzerland -> Bern)
   
   cap1("andorra")                                //> res3: String = <unknown>

   def showCapital(country: String) = capitalOfCountry.get(country) match {
      case Some(capital) => capital
      case None => "missing data"
   }                                              //> showCapital: (country: String)String
   
   showCapital("US")                              //> res4: String = Washington
   showCapital("Andorra")                         //> res5: String = missing data
   
   val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
   fruit sortWith (_.length < _.length)           //> res6: List[String] = List(pear, apple, orange, pineapple)
   fruit.sorted                                   //> res7: List[String] = List(apple, orange, pear, pineapple)
   
   fruit groupBy (_.head)                         //> res8: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
}