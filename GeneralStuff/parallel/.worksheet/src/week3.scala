import scala.collection._

object week3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 
  println("Welcome to the Scala worksheet");$skip(103); val res$0 = 
  
  (1 until 1000).par
    .filter(n => n % 3 == 0)
    .count(n => n.toString == n.toString.reverse);System.out.println("""res0: Int = """ + $show(res$0));$skip(119); 
    
    /// Sum of the elements of an array
    def sum(xs: Array[Int]): Int = {
    	xs.par.foldLeft(0)(_ + _)
    };System.out.println("""sum: (xs: Array[Int])Int""");$skip(22); val res$1 = 
    sum(Array(1,2,3));System.out.println("""res1: Int = """ + $show(res$1));$skip(124); 
    
    // Maximum element of an array
    def max(xs: Array[Int]): Int = {
    	xs.par.fold(Int.MinValue)(math.max)
    };System.out.println("""max: (xs: Array[Int])Int""");$skip(22); val res$2 = 
    max(Array(1,2,3));System.out.println("""res2: Int = """ + $show(res$2));$skip(374); 
    
    //Array("paper", "rock", "paper", "scissors").par.fold("")(play)
    
    def play(a: String, b: String): String = List(a, b).sorted match {
  		case List("paper", "scissors") => "scissors"
  		case List("paper", "rock")     => "paper"
  		case List("rock", "scissors")  => "rock"
  		case List(a, b) if a == b      => a
  		case List("", b)               => b
		};System.out.println("""play: (a: String, b: String)String""");$skip(338); 
    
    //
   // Array('E', 'P', 'F', 'L').par
     //    .fold(0)((count, c) => if (isVowel(c)) count + 1 else count)
     
     def largestPalindrome(xs: GenSeq[Int]): Int = {
  			xs.aggregate(Int.MinValue)(
    				(largest, n) =>
    				if (n > largest && n.toString == n.toString.reverse) n else largest,
    				math.max)
     };System.out.println("""largestPalindrome: (xs: scala.collection.GenSeq[Int])Int""");$skip(186); 
	
		//val array = (0 until 1000000).toArray
		
		def initializeArray(xs: Array[Int])(v: Int): Unit = {
        for (i <- (0 until xs.length).par) {
            xs(i) = v
        }
    };System.out.println("""initializeArray: (xs: Array[Int])(v: Int)Unit""");$skip(54); 
    
    val f = initializeArray( Array(1,2,3,4) )(3);System.out.println("""f  : Unit = """ + $show(f ))}
}
