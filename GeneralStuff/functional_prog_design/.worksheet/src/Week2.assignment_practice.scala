package Week2

object assignment_practice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 
  println("Welcome to the Scala worksheet");$skip(52); 
  
  // Create a Vector
  val v = Vector(1,2,3,4,5);System.out.println("""v  : scala.collection.immutable.Vector[Int] = """ + $show(v ));$skip(15); val res$0 = 
  
  v.lift(3);System.out.println("""res0: Option[Int] = """ + $show(res$0));$skip(12); val res$1 = 
  
  v.view;System.out.println("""res1: scala.collection.SeqView[Int,scala.collection.immutable.Vector[Int]] = """ + $show(res$1));$skip(65); 
  
  val v2 = Vector(Vector(6,2,3),Vector(4,5,1), Vector(7,8,9));System.out.println("""v2  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Int]] = """ + $show(v2 ));$skip(28); val res$2 = 
  v2 indexOf(Vector(1,2,3));System.out.println("""res2: Int = """ + $show(res$2));$skip(69); val res$3 = 
                                                  
  v2.zipWithIndex;System.out.println("""res3: scala.collection.immutable.Vector[(scala.collection.immutable.Vector[Int], Int)] = """ + $show(res$3));$skip(9); val res$4 = 
   v2(0);System.out.println("""res4: scala.collection.immutable.Vector[Int] = """ + $show(res$4));$skip(27); 
   
   var result =(-1,-1);System.out.println("""result  : (Int, Int) = """ + $show(result ));$skip(18); 
   
   val n = 10;System.out.println("""n  : Int = """ + $show(n ));$skip(92); val res$5 = 
   for {
     i <- 1 until n
     j <- 1 until i
     //if isPrime(i + j)
   } yield (i, j);System.out.println("""res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$5));$skip(110); 
   
   val res =for {
     i <- 0 until v2.size
     p = v2(i) indexOf(1)
     if ( p != -1)
   } yield(i, p);System.out.println("""res  : scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res ));$skip(38); 
   
   System.out.println( res.size );$skip(38); 
   
   println( res(0)._1, res(0)._2)}
   //for (i <- 0 until res.size ) {
   //   if( res(i)._1 != -1 && res(i)._2 != -1
   // }
}
