import scala.util.Random

object parallel {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> mcCount: (iter: Int)Int
  
	def monteCarloPiSeq(iter: Int): Double = 4.0 * mcCount(iter) / iter
                                                  //> monteCarloPiSeq: (iter: Int)Double

}