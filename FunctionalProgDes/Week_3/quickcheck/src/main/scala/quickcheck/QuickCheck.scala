package quickcheck


import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._
import org.scalacheck._
import org.scalacheck.Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  // This was there bofore
  // lazy val genHeap: Gen[H] = ???

  // This is my work
  lazy val genHeap: Gen[H]  = for {
    n <- arbitrary[A]
    h <- oneOf( const(empty), genHeap)
  } yield insert(n, h)
  // My work ends here

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)


  property("meldMinMove") = forAll { (h1: H, h2: H) =>
    def remMin(ts: H, as: List[Int]): List[Int] = {
      if (isEmpty(ts)) as
      else findMin(ts) :: remMin(deleteMin(ts), as)
    }
    val meld1 = meld(h1, h2)
    val min1 = findMin(h1)
    val meld2 = meld(deleteMin(h1), insert(min1, h2))
    val xs1 = remMin(meld1, Nil)
    val xs2 = remMin(meld2, Nil)
    xs1 == xs2
  }

}
