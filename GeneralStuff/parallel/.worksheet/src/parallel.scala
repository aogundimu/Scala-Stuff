import scala.util.Random

object parallel {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 
  println("Welcome to the Scala worksheet");$skip(282); 

  def mcCount(iter: Int): Int = {
  	val randomX = new Random
  	val randomY = new Random
  	var hits = 0
  	for (i <- 0 until iter) {
    	val x = randomX.nextDouble  // in [0,1]
    	val y = randomY.nextDouble  // in [0,1]
    	if (x*x + y*y < 1) hits= hits + 1
  	}
  	hits
  };System.out.println("""mcCount: (iter: Int)Int""");$skip(72); 
  
	def monteCarloPiSeq(iter: Int): Double = 4.0 * mcCount(iter) / iter;System.out.println("""monteCarloPiSeq: (iter: Int)Double""")}

}
