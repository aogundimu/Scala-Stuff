object listReduction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  println("Welcome to the Scala worksheet");$skip(244); 
  
  def times(chars: List[Char]): List[(Char, Int)] = {
     def incr(acc:Map[Char, Int], c:Char) = {
       val count = (acc get c).getOrElse(0) + 1
       acc + ((c, count))
     }

     (Map[Char,Int]() /: chars)(incr).iterator.toList
   }
  
   abstract class CodeTree
  	case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
    case class Leaf(char: Char, weight: Int) extends CodeTree;System.out.println("""times: (chars: List[Char])List[(Char, Int)]""");$skip(447); 
  
  def weight(tree: CodeTree): Int = tree match {
    //case Fork(_, _, _, w) => w
    //case Leaf(_, w) => w
    case Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) => weight
    case Leaf(char: Char, weight: Int) => weight
  };System.out.println("""weight: (tree: listReduction.CodeTree)Int""");$skip(281); 
  
  def chars(tree: CodeTree): List[Char] = tree match {
    //case Fork(_, _, charsL, _) => charsL
    //case Leaf(c1, _) => List(c1)
    case Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) => chars
    case Leaf(char: Char, weight: Int) => List(char)
  };System.out.println("""chars: (tree: listReduction.CodeTree)List[Char]""");$skip(209); 
  
   //def singleton(trees: List[CodeTree]): Boolean = trees.size == 1
   def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right));System.out.println("""makeCodeTree: (left: listReduction.CodeTree, right: listReduction.CodeTree)listReduction.Fork""");$skip(166); 
                                                  
   def singleton(trees: List[CodeTree]): Boolean = trees match {
    case t :: Nil => true
    case _ => false
  };System.out.println("""singleton: (trees: List[listReduction.CodeTree])Boolean""");$skip(97); 
  
  val sampleTree = makeCodeTree(
  makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
  Leaf('t', 2) );System.out.println("""sampleTree  : listReduction.Fork = """ + $show(sampleTree ))}
}
