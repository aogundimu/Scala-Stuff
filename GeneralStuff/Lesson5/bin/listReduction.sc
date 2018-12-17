object listReduction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def times(chars: List[Char]): List[(Char, Int)] = {
     def incr(acc:Map[Char, Int], c:Char) = {
       val count = (acc get c).getOrElse(0) + 1
       acc + ((c, count))
     }

     (Map[Char,Int]() /: chars)(incr).iterator.toList
   }                                              //> times: (chars: List[Char])List[(Char, Int)]
  
   abstract class CodeTree
  	case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
    case class Leaf(char: Char, weight: Int) extends CodeTree
  
  def weight(tree: CodeTree): Int = tree match {
    //case Fork(_, _, _, w) => w
    //case Leaf(_, w) => w
    case Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) => weight
    case Leaf(char: Char, weight: Int) => weight
  }                                               //> weight: (tree: listReduction.CodeTree)Int
  
  def chars(tree: CodeTree): List[Char] = tree match {
    //case Fork(_, _, charsL, _) => charsL
    //case Leaf(c1, _) => List(c1)
    case Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) => chars
    case Leaf(char: Char, weight: Int) => List(char)
  }                                               //> chars: (tree: listReduction.CodeTree)List[Char]
  
   //def singleton(trees: List[CodeTree]): Boolean = trees.size == 1
   def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))
                                                  //> makeCodeTree: (left: listReduction.CodeTree, right: listReduction.CodeTree)
                                                  //| listReduction.Fork
                                                  
   def singleton(trees: List[CodeTree]): Boolean = trees match {
    case t :: Nil => true
    case _ => false
  }                                               //> singleton: (trees: List[listReduction.CodeTree])Boolean
  
  val sampleTree = makeCodeTree(
  makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
  Leaf('t', 2) )                                  //> sampleTree  : listReduction.Fork = Fork(Fork(Leaf(x,1),Leaf(e,1),List(x, e)
                                                  //| ,2),Leaf(t,2),List(x, e, t),4)
}