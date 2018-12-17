package Week2

object assignment_practice {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Create a Vector
  val v = Vector(1,2,3,4,5)                       //> v  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)
  
  v.lift(3)                                       //> res0: Option[Int] = Some(4)
  
  v.view                                          //> res1: scala.collection.SeqView[Int,scala.collection.immutable.Vector[Int]] =
                                                  //|  SeqView(...)
  
  val v2 = Vector(Vector(6,2,3),Vector(4,5,1), Vector(7,8,9))
                                                  //> v2  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[In
                                                  //| t]] = Vector(Vector(6, 2, 3), Vector(4, 5, 1), Vector(7, 8, 9))
  v2 indexOf(Vector(1,2,3))                       //> res2: Int = -1
                                                  
  v2.zipWithIndex                                 //> res3: scala.collection.immutable.Vector[(scala.collection.immutable.Vector[I
                                                  //| nt], Int)] = Vector((Vector(6, 2, 3),0), (Vector(4, 5, 1),1), (Vector(7, 8, 
                                                  //| 9),2))
   v2(0)                                          //> res4: scala.collection.immutable.Vector[Int] = Vector(6, 2, 3)
   
   var result =(-1,-1)                            //> result  : (Int, Int) = (-1,-1)
   
   val n = 10                                     //> n  : Int = 10
   for {
     i <- 1 until n
     j <- 1 until i
     //if isPrime(i + j)
   } yield (i, j)                                 //> res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5), (7,1), (7,2), (7,3), (7,4), (7,5), (7,6), (8,1), (8,2), (8
                                                  //| ,3), (8,4), (8,5), (8,6), (8,7), (9,1), (9,2), (9,3), (9,4), (9,5), (9,6), (
                                                  //| 9,7), (9,8))
   
   val res =for {
     i <- 0 until v2.size
     p = v2(i) indexOf(1)
     if ( p != -1)
   } yield(i, p)                                  //> res  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,2))
   
   System.out.println( res.size )                 //> 1
   
   println( res(0)._1, res(0)._2)                 //> (1,2)
   //for (i <- 0 until res.size ) {
   //   if( res(i)._1 != -1 && res(i)._2 != -1
   // }
}