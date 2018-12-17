package pouring

object test {

   val problem = new Pouring(Vector(4,9))         //> problem  : pouring.Pouring = pouring.Pouring@39fb3ab6
   problem.moves                                  //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with po
                                                  //| uring.test.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Pour(
                                                  //| 0,1), Pour(1,0))
                                                  
   val problem2 = new Pouring(Vector(4,7))        //> problem2  : pouring.Pouring = pouring.Pouring@4de8b406
   problem2.moves                                 //> res1: scala.collection.immutable.IndexedSeq[Product with Serializable with p
                                                  //| ouring.test.problem2.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Po
                                                  //| ur(0,1), Pour(1,0))
   
   //problem.pathSets
   problem.solutions(6)                           //> res2: Stream[pouring.test.problem.Path] = Stream(Fill(1) Pour(1,0) Empty(0) 
                                                  //| Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)--> Vector(4, 6), ?)
}