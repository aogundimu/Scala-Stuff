/**
 * Assignment 4: Huffman coding
 *
 */
object Huffman1 {

  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

  // Part 1: Basics

  def weight(tree: CodeTree): Int = tree match {
    case Fork(_, _, _, w) => w
    case Leaf(_, w) => w
  } // tree match ...                       //> weight: (tree: Huffman1.CodeTree)Int

  def chars(tree: CodeTree): List[Char] = tree match {
    case Fork(_, _, chars, _) => chars
    case Leaf(char, _) => List(char)
  }                                         //> chars: (tree: Huffman1.CodeTree)List[Char]

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))
                                                  //> makeCodeTree: (left: Huffman1.CodeTree, right: Huffman1.CodeTree)Huffman1.Fo
                                                  //| rk

val sampleTree = makeCodeTree(
  makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
  Leaf('t', 2)
)                                                 //> sampleTree  : Huffman1.Fork = Fork(Fork(Leaf(x,1),Leaf(e,1),List(x, e),2),Le
                                                  //| af(t,2),List(x, e, t),4)
 


  // Part 2: Generating Huffman trees

  /**
   * In this assignment, we are working with lists of characters. This function allows
   * you to easily create a character list from a given string.
   */
  def string2Chars(str: String): List[Char] = str.toList
                                                  //> string2Chars: (str: String)List[Char]

  def times(chars: List[Char]): List[(Char, Int)] = {
    /*val map0: Map [Char, Int] = Map().withDefaultValue (0)
    chars.foldLeft(map0)((m, letter) => m + (letter -> (m(letter) + 1))).toList*/
    chars map (c => (c, chars count {_ == c}))
  }                                         //> times: (chars: List[Char])List[(Char, Int)]
 
  val t = times("abcddd" toList)            //> t  : List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,3))
 
//  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
//    freqs sortWith((_, _) match {case ((aa, ab), (ba, bb)) => ab < bb}) map (x => x match {case (a, b) => new Leaf(a, b)})
//  }

  def insertSorted[T <: CodeTree](item: T, input: List[T]): List[T] = {
    if (input.isEmpty || weight(item) <= weight(input.head)) item :: input
    else input.head :: insertSorted(item, input.tail)
  }                                         //> insertSorted: [T <: Huffman1.CodeTree](item: T, input: List[T])List[T]
 
  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    //freqs.foldLeft(Nil: List[Leaf]) ((res, a) => insertSorted[Leaf](Leaf(a. _1, a. _2), res))
    freqs.map {case (c, w) => Leaf(c, w)}.toSet.toList.sortWith((l1: Leaf, l2: Leaf) => l1.weight < l2.weight)
  }                                         //> makeOrderedLeafList: (freqs: List[(Char, Int)])List[Huffman1.Leaf]

  /**
   * Checks whether the list `trees` contains only one single code tree.
   */
  def singleton(trees: List[CodeTree]): Boolean = trees.length == 1
                                                  //> singleton: (trees: List[Huffman1.CodeTree])Boolean
 
  List(Leaf('a', 1), Leaf('b', 3), Leaf('c', 2)).foldLeft(List[CodeTree]()) ((res, a) => insertSorted(a, res))
                                                  //> res0: List[Huffman1.CodeTree] = List(Leaf(a,1), Leaf(c,2), Leaf(b,3))



  val leafs = makeOrderedLeafList(List(('a', 2), ('b', 3), ('c', 1)))
                                                  //> leafs  : List[Huffman1.Leaf] = List(Leaf(c,1), Leaf(a,2), Leaf(b,3))
  def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
    //case x :: y :: tail => insertSorted(makeCodeTree(x, y), tail)
    case l :: r :: t => Fork(l, r, chars (l) ::: chars(r), weight(l) + weight(r)) :: t
  }                                         //> combine: (trees: List[Huffman1.CodeTree])List[Huffman1.CodeTree]

 
  def until[A](singleton: A => Boolean, combine: A => A)(data: A): A = {
    //println(" until " + data)
    if (singleton(data)) data else until(singleton, combine)(combine(data))
  }                                         //> until: [A](singleton: A => Boolean, combine: A => A)(data: A)A
 
  until(singleton, combine)(leafs)          //> res1: List[Huffman1.CodeTree] = List(Fork(Fork(Leaf(c,1),Leaf(a,2),List(c, 
                                                  //| a),3),Leaf(b,3),List(c, a, b),6))
 
  def createCodeTree(chars: List[Char]): CodeTree = {
    val orderedLeaves = makeOrderedLeafList(times(chars))
    until(singleton, combine)(orderedLeaves).head
  }                                         //> createCodeTree: (chars: List[Char])Huffman1.CodeTree
 
  val t = createCodeTree("dadbdad".toList)        //> t  : ws1.CodeTree = Fork(Fork(Leaf(b,1),Leaf(a,2),List(b, a),3),Leaf(d,4),L

  type Bit = Int

  def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    /*bits.foldLeft (List[Char]() -> tree) {case ((list, t), bit) =>
      val fork = t.asInstanceOf[Fork]
      //println("descending "  + bit)
      val next = if (bit == 1) fork.right else fork.left
      if (next.isInstanceOf[Leaf])
        (chars(next)(0) :: list) -> tree
      else
        list -> next
    }. _1 . reverse*/
    
  	def rec(tree: CodeTree, bits: List[Bit], acc: List[Char]): List[Char] = tree match {
	  	case Leaf(c, _) => if (bits == Nil) c :: acc else rec(root, bits, c :: acc)
	  	case Fork(l, r, chars, _) => rec(if (bits.head == 0) l else r, bits.tail, acc)
	  }
	  rec(root, bits, Nil).reverse

  }                                         //> decode: (tree: Huffman1.CodeTree, bits: List[Huffman1.Bit])List[Char]
 
  val frenchCode: CodeTree = Fork(Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x','j'),14279),Leaf('f',16351),List('x','j','f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k','w'),2492),List('z','k','w'),4585),Leaf('y',4725),List('z','k','w','y'),9310),Leaf('h',11298),List('z','k','w','y','h'),20608),Leaf('q',20889),List('z','k','w','y','h','q'),41497),List('x','j','f','z','k','w','y','h','q'),72127),List('d','x','j','f','z','k','w','y','h','q'),128396),List('s','d','x','j','f','z','k','w','y','h','q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o','l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m','p'),91856),Leaf('u',96785),List('m','p','u'),188641),List('o','l','m','p','u'),355071),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u'),605362),Fork(Fork(Fork(Leaf('r',100500),Fork(Leaf('c',50003),Fork(Leaf('v',24975),Fork(Leaf('g',13288),Leaf('b',13822),List('g','b'),27110),List('v','g','b'),52085),List('c','v','g','b'),102088),List('r','c','v','g','b'),202588),Fork(Leaf('n',108812),Leaf('t',111103),List('n','t'),219915),List('r','c','v','g','b','n','t'),422503),Fork(Leaf('e',225947),Fork(Leaf('i',115465),Leaf('a',117110),List('i','a'),232575),List('e','i','a'),458522),List('r','c','v','g','b','n','t','e','i','a'),881025),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u','r','c','v','g','b','n','t','e','i','a'),1486387)
                                                  //> frenchCode  : Huffman1.CodeTree = Fork(Fork(Fork(Leaf(s,121895),Fork(Leaf(d
                                                  //| ,56269),Fork(Fork(Fork(Leaf(x,5928),Leaf(j,8351),List(x, j),14279),Leaf(f,1
                                                  //| 6351),List(x, j, f),30630),Fork(Fork(Fork(Fork(Leaf(z,2093),Fork(Leaf(k,745
                                                  //| ),Leaf(w,1747),List(k, w),2492),List(z, k, w),4585),Leaf(y,4725),List(z, k,
                                                  //|  w, y),9310),Leaf(h,11298),List(z, k, w, y, h),20608),Leaf(q,20889),List(z,
                                                  //|  k, w, y, h, q),41497),List(x, j, f, z, k, w, y, h, q),72127),List(d, x, j,
                                                  //|  f, z, k, w, y, h, q),128396),List(s, d, x, j, f, z, k, w, y, h, q),250291)
                                                  //| ,Fork(Fork(Leaf(o,82762),Leaf(l,83668),List(o, l),166430),Fork(Fork(Leaf(m,
                                                  //| 45521),Leaf(p,46335),List(m, p),91856),Leaf(u,96785),List(m, p, u),188641),
                                                  //| List(o, l, m, p, u),355071),List(s, d, x, j, f, z, k, w, y, h, q, o, l, m, 
                                                  //| p, u),605362),Fork(Fork(Fork(Leaf(r,100500),Fork(Leaf(c,50003),Fork(Leaf(v,
                                                  //| 24975),Fork(Leaf(g,13288),Leaf(b,13822),List(g, b),27110),List(v, g, b),520
                                                  //| 85),List(c, v, g, b),10
                                                  //| Output exceeds cutoff limit.
  val secret: List[Bit] = List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1)
                                                  //> secret  : List[Huffman1.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 
                                                  //| 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 
                                                  //| 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1)
                                                  //| 

  def decodedSecret: List[Char] = decode(frenchCode, secret)
                                                  //> decodedSecret: => List[Char]
  decodedSecret                             //> res6: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
 
  def encode(tree: CodeTree)(text: List[Char]): List[Bit] = {
    /*//println ("tree = " + tree)
    text.foldLeft (List[Bit]()) ((list, char) => {
        //println(char)
        type Pair = (CodeTree, List[Bit])
        until[Pair](
            {case (tree, acc) => tree.isInstanceOf[Leaf]}, // until singletone
            {case (Fork(left, right, _, _) , acc) =>  // until - combine
                if (chars(left) contains char) {left -> (0 :: acc)} else {right -> (1 :: acc)}
            }
          ) (tree -> list) . _2
      }
 
    ). reverse*/
	text.foldLeft(List[Bit]()){(acc, c) =>
	  def rec(tree: CodeTree, acc: List[Bit]): List[Bit] = tree match {
	  	case Leaf(c, _) => acc
	  	case Fork(l, r, _, _) => if (chars(l) contains c) rec(l, 0 :: acc) else rec(r, 1 :: acc)
	  }
	  rec(root, acc)
	}.reverse

  }                                         //> encode: (tree: Huffman1.CodeTree)(text: List[Char])List[Huffman1.Bit]
 
  def check(a: Any, b: Any): Unit = {
    assert(a == b, a + " != "+ b)
  }                                         //> check: (a: Any, b: Any)Unit
 
	var sec2 = encode(frenchCode)(decodedSecret)
                                                  //> sec2  : List[ws1.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0
                                                  //| , 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0
                                                  //| , 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1)
	decode(frenchCode, sec2)                  //> res1: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

	val plainCode = createCodeTree(decodedSecret)
                                                  //> plainCode  : ws1.CodeTree = Fork(Fork(Fork(Fork(Fork(Fork(Fork(Fork(Fork(Fo
                                                  //| rk(Fork(Leaf(e,1),Leaf(u,1),List(e, u),2),Leaf(m,1),List(e, u, m),3),Leaf(t
                                                  //| ,1),List(e, u, m, t),4),Leaf(s,1),List(e, u, m, t, s),5),Leaf(h,1),List(e, 
                                                  //| u, m, t, s, h),6),Leaf(n,1),List(e, u, m, t, s, h, n),7),Leaf(l,1),List(e, 
                                                  //| u, m, t, s, h, n, l),8),Leaf(c,1),List(e, u, m, t, s, h, n, l, c),9),Leaf(a
                                                  //| ,1),List(e, u, m, t, s, h, n, l, c, a),10),Leaf(f,2),List(e, u, m, t, s, h,
                                                  //|  n, l, c, a, f),12),Leaf(o,2),List(e, u, m, t, s, h, n, l, c, a, f, o),14)
                                                  //| 
	val plaincoded = encode(plainCode)(decodedSecret)
                                                  //> plaincoded  : List[ws1.Bit] = List(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0
                                                  //| , 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0
                                                  //| , 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0
                                                  //| , 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1)
	println ("french-coded len = " + sec2.length + ", plain coded len is " + plaincoded.length)
                                                  //| 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 
                                                  //| 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1)
                                                  //| decoded  = List(t, h, i, s,  , i, s,  , m, y,  , m, e, s, s, a, g, e)
                                                  //| res8: List[Huffman1.Bit] = List(1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1
                                                  //| , 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0
                                                  //| , 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1)

 
 
  // Part 4b: Encoding using code table
  
	// Here is some shit I cannot undestand. ProgFun claims that the following list-based table is
	// "more efficient" than the list-based tree lookup. Which is obvious nonsense. My analysis
	// indicates that you must scan a half of the table in order to find the bits for a character.
	// Same happens with tree. You first scan through the left branch of the root. The branch
	// contains only 1/2 of the characters, and its lookup will cost 1/4 in average. You then scan
	// 1/8 of chars in average at the second level and so on. The total cost, 1/4/+1/8+... = 1/2,
	// is exactly the complexity of list-based implementation. How do you call one of the identical
	// items "more efficient"?

  type CodeTable = List[(Char, List[Bit])]

  /**
   * This function returns the bit sequence that represents the character `char` in
   * the code table `table`.
   */

 
/* Custom lookup
def codeBits(table: CodeTable)(char: Char): List[Bit] = table match {
    case x :: xs => if (x. _1 == char) x._2 else codeBits(xs)(char)
  }*/
 
  def codeBits(table: CodeTable)(char: Char): List[Bit] = {
    table.find(_._1 == char).get._2
  }                                         //> codeBits: (table: Huffman1.CodeTable)(char: Char)List[Huffman1.Bit]


  def convert(tree: CodeTree): CodeTable = {
    chars(tree).map(char => (char -> encode(tree)(List(char))))
  }                                         //> convert: (tree: Huffman1.CodeTree)Huffman1.CodeTable
 
 

  def mergeCodeTables(a: CodeTable, b: CodeTable): CodeTable = {
    a ::: b
  }                                         //> mergeCodeTables: (a: Huffman1.CodeTable, b: Huffman1.CodeTable)Huffman1.Cod
                                                  //| eTable

  def quickEncode(tree: CodeTree)(text: List[Char]): List[Bit] = {
    val table = convert(tree)
    text.flatMap(codeBits(table)(_))
  }                                         //> quickEncode: (tree: Huffman1.CodeTree)(text: List[Char])List[Huffman1.Bit]
                                                  //| 
 


  val fast = decode(frenchCode, quickEncode(frenchCode)(decodedSecret))
                                                  //> fast  : List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  check(decodedSecret, fast)
                                                  //| decoded = List(a, a, b, c)
                                                  //| compressed = List(1, 1, 0, 1, 0, 0)
                                                  //| decoded  = List(a, a, b, c)

  class TimeResult[A](val result: A, val time: Long)
	
  def measureTime[A](f: => A): TimeResult[A] = {
    val time1 = System.currentTimeMillis()
    new TimeResult(f, System.currentTimeMillis() - time1)
  }                                         //> measureTime: [A](f: => A)Huffman1.TimeResult[A]
  def random(len: Int) {
    (1 to 5).foreach { between =>
      val seq = scala.util.Random.alphanumeric.take(len).toList
      val dict = createCodeTree(seq)
      (1 to 5) foreach { within =>
        val compressed = measureTime({encode(dict)(seq)})
        val fastComp = measureTime({quickEncode(dict)(seq)})
        assert (compressed.result.length == fastComp.result.length)
        if (within == 1) println("compressed " + seq.length + "-char msg into " + compressed.result.length + " bits")
        println(" in " + compressed.time + " (tree) vs " + fastComp.time + " (table) msec")
      }
    }
	
  }                                         //> random: (len: Int)Unit
	
  random(10000)                             //> compressed 10000-char msg into 59609 bits
                                                  //|  in 79 (tree) vs 19 (table) msec
                                                  //|  in 40 (tree) vs 13 (table) msec
                                                  //|  in 38 (tree) vs 45 (table) msec
                                                  //|  in 34 (tree) vs 26 (table) msec
                                                  //|  in 36 (tree) vs 17 (table) msec
                                                  //| compressed 10000-char msg into 59621 bits
                                                  //|  in 37 (tree) vs 20 (table) msec
                                                  //|  in 38 (tree) vs 19 (table) msec
                                                  //|  in 224 (tree) vs 11 (table) msec
                                                  //|  in 78 (tree) vs 22 (table) msec
                                                  //|  in 46 (tree) vs 19 (table) msec
                                                  //| compressed 10000-char msg into 59614 bits
                                                  //|  in 114 (tree) vs 12 (table) msec
                                                  //|  in 52 (tree) vs 26 (table) msec
                                                  //|  in 86 (tree) vs 25 (table) msec
                                                  //|  in 64 (tree) vs 11 (table) msec
                                                  //|  in 103 (tree) vs 12 (table) msec
                                                  //| compressed 10000-char msg into 59620 bits
                                                  //|  in 62 (tree) vs 10 (table) msec
                                                  //|  in 84 (tree) vs 11 (table) msec
                                                  //|  in 55 (tree) vs 11 (table) msec
                                                  //|  in 42 (tree) vs 11 (table) msec
                                                  //|  in 79 (tree) vs 16 (table) msec
                                                  //| compressed 10000-cha
                                                  //| Output exceeds cutoff limit.
  println("done")                           //> done
	

}
