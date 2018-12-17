import scala.collection._

object week3 {
  println("Welcome to the Scala worksheet")
  
  (1 until 1000).par
    .filter(n => n % 3 == 0)
    .count(n => n.toString == n.toString.reverse)
    
    /// Sum of the elements of an array
    def sum(xs: Array[Int]): Int = {
    	xs.par.foldLeft(0)(_ + _)
    }
    sum(Array(1,2,3))
    
    // Maximum element of an array
    def max(xs: Array[Int]): Int = {
    	xs.par.fold(Int.MinValue)(math.max)
    }
    max(Array(1,2,3))
    
    //Array("paper", "rock", "paper", "scissors").par.fold("")(play)
    
    def play(a: String, b: String): String = List(a, b).sorted match {
  		case List("paper", "scissors") => "scissors"
  		case List("paper", "rock")     => "paper"
  		case List("rock", "scissors")  => "rock"
  		case List(a, b) if a == b      => a
  		case List("", b)               => b
		}
    
    //
   // Array('E', 'P', 'F', 'L').par
     //    .fold(0)((count, c) => if (isVowel(c)) count + 1 else count)
     
     def largestPalindrome(xs: GenSeq[Int]): Int = {
  			xs.aggregate(Int.MinValue)(
    				(largest, n) =>
    				if (n > largest && n.toString == n.toString.reverse) n else largest,
    				math.max)
     }
	
		//val array = (0 until 1000000).toArray
		
		def initializeArray(xs: Array[Int])(v: Int): Unit = {
        for (i <- (0 until xs.length).par) {
            xs(i) = v
        }
    }
    
    val f = initializeArray( Array(1,2,3,4) )(3)
}