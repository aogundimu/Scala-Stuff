package Week2

object stream_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(152); 
  
   def isPrime(v: Int): Boolean = {
    if (v <= 1)
      false
    else if (v == 2)
      true
    else !(2 to (v - 1)).exists(x => v % x == 0)
  };System.out.println("""isPrime: (v: Int)Boolean""");$skip(70); val res$0 = 

  //val s = streamRange(1,10)
  ((1000 to 10000) filter isPrime)(10);System.out.println("""res0: Int = """ + $show(res$0));$skip(47); val res$1 = 
  ((1000 to 10000).toStream filter isPrime)(1);System.out.println("""res1: Int = """ + $show(res$1));$skip(82); 
  
  //x::xs
  
  def greaterThanFive(v : Int) : Boolean = {
  	return v > 5
  	};System.out.println("""greaterThanFive: (v: Int)Boolean""");$skip(40); val res$2 = 
  
  ((1 to 10) filter greaterThanFive);System.out.println("""res2: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$2))}
}
