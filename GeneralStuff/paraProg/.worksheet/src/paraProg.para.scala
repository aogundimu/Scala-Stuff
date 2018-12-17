package paraProg

import scala.util.Random

object para {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(101); 
  println("Welcome to the Scala worksheet");$skip(281); 

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
  
	def monteCarloPiSeq(iter: Int): Double = 4.0 * mcCount(iter) / iter;System.out.println("""monteCarloPiSeq: (iter: Int)Double""");$skip(244); 
	
	def monteCarloPiPar(iter: Int): Double = {
  	val ((pi1, pi2), (pi3, pi4)) = parallel(
    	parallel(mcCount(iter/4), mcCount(iter/4)),
    	parallel(mcCount(iter/4), mcCount(iter - 3*(iter/4))))
    	4.0 * (pi1 + pi2 + pi3 + pi4) / iter
	};System.out.println("""monteCarloPiPar: (iter: Int)Double""")}
}
