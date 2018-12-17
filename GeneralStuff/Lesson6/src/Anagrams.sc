object Anagrams {
   println("Welcome to the Scala worksheet")      //> Welcome to the Scala worksheet
  
   type Word = String
   type Sentence = List[Word]
   type Occurrences = List[(Char, Int)]
  
   val w = "ASDF GHJ ASDEW"                       //> w  : String = ASDF GHJ ASDEW
  
   w.toLowerCase                                  //> res0: String = asdf ghj asdew
  
   w.toLowerCase groupBy(x => x) mapValues(x => x.length) toList
                                                  //> res1: List[(Char, Int)] = List((e,1), (s,2), (j,1), (f,1), (a,2), ( ,2), (g,
                                                  //| 1), (h,1), (w,1), (d,2))
   def wordOccurrences(w: Word): Occurrences = w.toLowerCase.groupBy(x => x).mapValues(x => x.length).toList.sorted
                                                  //> wordOccurrences: (w: Anagrams.Word)Anagrams.Occurrences
   
   def sentenceOccurrences(s: Sentence): Occurrences = {
    wordOccurrences(s.flatten.mkString)
  }                                               //> sentenceOccurrences: (s: Anagrams.Sentence)Anagrams.Occurrences
  
  val l = List("you", "are", "cool")              //> l  : List[String] = List(you, are, cool)
  
  sentenceOccurrences(l)                          //> res2: Anagrams.Occurrences = List((a,1), (c,1), (e,1), (l,1), (o,3), (r,1), 
                                                  //| (u,1), (y,1))
 
}