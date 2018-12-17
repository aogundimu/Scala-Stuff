object Anagrams {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
   println("Welcome to the Scala worksheet")
  
   type Word = String
   type Sentence = List[Word]
   type Occurrences = List[(Char, Int)];$skip(126); 
  
   val w = "ASDF GHJ ASDEW";System.out.println("""w  : String = """ + $show(w ));$skip(20); val res$0 = 
  
   w.toLowerCase;System.out.println("""res0: String = """ + $show(res$0));$skip(68); val res$1 = 
  
   w.toLowerCase groupBy(x => x) mapValues(x => x.length) toList;System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(116); 
   def wordOccurrences(w: Word): Occurrences = w.toLowerCase.groupBy(x => x).mapValues(x => x.length).toList.sorted;System.out.println("""wordOccurrences: (w: Anagrams.Word)Anagrams.Occurrences""");$skip(105); 
   
   def sentenceOccurrences(s: Sentence): Occurrences = {
    wordOccurrences(s.flatten.mkString)
  };System.out.println("""sentenceOccurrences: (s: Anagrams.Sentence)Anagrams.Occurrences""");$skip(40); 
  
  val l = List("you", "are", "cool");System.out.println("""l  : List[String] = """ + $show(l ));$skip(28); val res$2 = 
  
  sentenceOccurrences(l);System.out.println("""res2: Anagrams.Occurrences = """ + $show(res$2))}
 
}
