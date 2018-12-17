package pouring

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 

   val problem = new Pouring(Vector(4,9));System.out.println("""problem  : pouring.Pouring = """ + $show(problem ));$skip(17); val res$0 = 
   problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with pouring.test.problem.Move] = """ + $show(res$0));$skip(94); 
                                                  
   val problem2 = new Pouring(Vector(4,7));System.out.println("""problem2  : pouring.Pouring = """ + $show(problem2 ));$skip(18); val res$1 = 
   problem2.moves;System.out.println("""res1: scala.collection.immutable.IndexedSeq[Product with Serializable with pouring.test.problem2.Move] = """ + $show(res$1));$skip(50); val res$2 = 
   
   //problem.pathSets
   problem.solutions(6);System.out.println("""res2: Stream[pouring.test.problem.Path] = """ + $show(res$2))}
}
