package Week2

object stream_worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
   def isPrime(v: Int): Boolean = {
    if (v <= 1)
      false
    else if (v == 2)
      true
    else !(2 to (v - 1)).exists(x => v % x == 0)
  }                                               //> isPrime: (v: Int)Boolean

  //val s = streamRange(1,10)
  ((1000 to 10000) filter isPrime)(10)            //> res0: Int = 1063
  ((1000 to 10000).toStream filter isPrime)(1)    //> res1: Int = 1013
  
  //x::xs 
  
  def greaterThanFive(v : Int) : Boolean = {
  	return v > 5
  	}                                         //> greaterThanFive: (v: Int)Boolean
  
  ((1 to 10) filter greaterThanFive)              //> res2: scala.collection.immutable.IndexedSeq[Int] = Vector(6, 7, 8, 9, 10)
}