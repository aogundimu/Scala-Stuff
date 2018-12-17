package Week1

object generators {
  println("Welcome to the Scala worksheet")
  
  
  // A generator for generating different random types
  trait Generator[+T] {
  
    self =>
   
  	def generate: T
  	
  	def map[S](f: T => S): Generator[S] = new Generator[S] {
  	  def generate = f(self.generate)
  	}
  	
  	def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
  	  def generate = f(self.generate).generate
  	}
  }
  
  val integers = new Generator[Int] {
  	//val rand = new java.util.Random
  	//def generate = rand.nextInt()
  	def generate = scala.util.Random.nextInt()
  }
  
  val booleans = new Generator[Boolean] {
  	def generate = integers.generate > 0
  }
  
  val pairs = new Generator[(Int,Int)] {
    def generate = (integers.generate, integers.generate)
  }
  
  val bools = for(x <- integers) yield x > 0
  val bools1 = integers map { x => x > 0 }
  
  val bools2 = new Generator[Boolean] {
  	integers.generate > 0
  }
  
  
  def test[T](g: Generator[T], numTimes: Int = 100)
      (test: T => Boolean): Unit = {
    for (i <- 0 until numTimes) {
      val value = g.generate
      assert(test(value), "test failed for " + value)
    }
   
    println("passed " + numTimes + " tests")
  }
  
  val l = List(1,3,4,4)
  
  /////////////  Tree Generator
  val new_booleans = integers.map(_ >= 0)
  
  def leafs: Generator[Leaf] = for {
     x <- integers
  } yield Leaf(x)
  
}