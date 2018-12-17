package week6

object maps {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet");$skip(58); 

  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10);System.out.println("""romanNumerals  : scala.collection.immutable.Map[Char,Int] = """ + $show(romanNumerals ));$skip(76); 
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern");System.out.println("""capitalOfCountry  : scala.collection.immutable.Map[String,String] = """ + $show(capitalOfCountry ));$skip(26); val res$0 = 
   capitalOfCountry("US");System.out.println("""res0: String = """ + $show(res$0));$skip(67); val res$1 = 
   //capitalOfCountry("andorra")
   capitalOfCountry get "andorra";System.out.println("""res1: Option[String] = """ + $show(res$1));$skip(29); val res$2 = 
   capitalOfCountry get "US";System.out.println("""res2: Option[String] = """ + $show(res$2));$skip(64); 
   
   val cap1 = capitalOfCountry withDefaultValue "<unknown>";System.out.println("""cap1  : scala.collection.immutable.Map[String,String] = """ + $show(cap1 ));$skip(23); val res$3 = 
   
   cap1("andorra");System.out.println("""res3: String = """ + $show(res$3));$skip(152); 

   def showCapital(country: String) = capitalOfCountry.get(country) match {
      case Some(capital) => capital
      case None => "missing data"
   };System.out.println("""showCapital: (country: String)String""");$skip(25); val res$4 = 
   
   showCapital("US");System.out.println("""res4: String = """ + $show(res$4));$skip(26); val res$5 = 
   showCapital("Andorra");System.out.println("""res5: String = """ + $show(res$5));$skip(64); 
   
   val fruit = List("apple", "pear", "orange", "pineapple");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(40); val res$6 = 
   fruit sortWith (_.length < _.length);System.out.println("""res6: List[String] = """ + $show(res$6));$skip(16); val res$7 = 
   fruit.sorted;System.out.println("""res7: List[String] = """ + $show(res$7));$skip(30); val res$8 = 
   
   fruit groupBy (_.head);System.out.println("""res8: scala.collection.immutable.Map[Char,List[String]] = """ + $show(res$8))}
}
