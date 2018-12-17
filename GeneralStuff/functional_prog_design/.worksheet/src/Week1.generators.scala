package Week1

object generators {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
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
  };$skip(526); 
  
  val integers = new Generator[Int] {
  	//val rand = new java.util.Random
  	//def generate = rand.nextInt()
  	def generate = scala.util.Random.nextInt()
  };System.out.println("""integers  : Week1.generators.Generator[Int] = """ + $show(integers ));$skip(89); 
  
  val booleans = new Generator[Boolean] {
  	def generate = integers.generate > 0
  };System.out.println("""booleans  : Week1.generators.Generator[Boolean] = """ + $show(booleans ));$skip(106); 
  
  val pairs = new Generator[(Int,Int)] {
    def generate = (integers.generate, integers.generate)
  };System.out.println("""pairs  : Week1.generators.Generator[(Int, Int)] = """ + $show(pairs ));$skip(48); 
  
  val bools = for(x <- integers) yield x > 0;System.out.println("""bools  : Week1.generators.Generator[Boolean] = """ + $show(bools ));$skip(43); 
  val bools1 = integers map { x => x > 0 };System.out.println("""bools1  : Week1.generators.Generator[Boolean] = """ + $show(bools1 ));$skip(72); 
  
  val bools2 = new Generator[Boolean] {
  	integers.generate > 0
  };System.out.println("""bools2  : Week1.generators.Generator[Boolean] = """ + $show(bools2 ));$skip(271); 
  
  
  def test[T](g: Generator[T], numTimes: Int = 100)
      (test: T => Boolean): Unit = {
    for (i <- 0 until numTimes) {
      val value = g.generate
      assert(test(value), "test failed for " + value)
    }
   
    println("passed " + numTimes + " tests")
  };System.out.println("""test: [T](g: Week1.generators.Generator[T], numTimes: Int)(test: T => Boolean)Unit""");$skip(27); 
  
  val l = List(1,3,4,4);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(77); 
  
  /////////////  Tree Generator
  val new_booleans = integers.map(_ >= 0);System.out.println("""new_booleans  : Week1.generators.Generator[Boolean] = """ + $show(new_booleans ));$skip(77); 
  
  def leafs: Generator[Leaf] = for {
     x <- integers
  } yield Leaf(x);System.out.println("""leafs: => Week1.generators.Generator[<error>]""")}
  
}
