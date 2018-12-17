package patmat

import common._

object Huffman {
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

  // Part 1: Basics

  def weight(t: CodeTree): Int = t match {
    case Fork(_, _, _, w) => w
    case Leaf(_, w) => w
  }

  def chars(t: CodeTree): List[Char] = t match {
    case Fork(_, _, cs, _) => cs
    case Leaf(c, _) => List(c)
  }

  def makeCodeTree(l: CodeTree, r: CodeTree) =
    Fork(l, r, chars(l) ::: chars(r), weight(l) + weight(r))

  // Part 2: Generating Huffman trees

  def string2Chars(str: String): List[Char] = str.toList

  implicit def enhanceWithGroup[A](xs: List[A]) = new {
    def group(): List[List[A]] = xs.foldRight(Nil:List[List[A]])((x, a) => a match {
      case Nil => List(List(x))
      case (v :: vs) :: ts =>
        if (v == x) (x :: v :: vs) :: ts
        else List(x) :: ((v :: vs) :: ts)
      })
  }
  def times(cs: List[Char]): List[(Char, Int)] = (cs.sortWith(_<_)).group().map(xs => (xs.head, xs.length))

  def makeOrderedLeafList(fs: List[(Char, Int)]): List[Leaf] =
    fs.sortWith((_,_) match {case ((c, fc), (d, fd)) => fc < fd}).map(_ match {case (c,w) => new Leaf(c,w)})

  def singleton(ts: List[CodeTree]): Boolean = ts match {
    case t :: Nil => true
    case _ => false
  }

  def combine(ts: List[CodeTree]): List[CodeTree] = ts match {
    case l :: r :: ts_ => (new Fork(l, r, chars(l) ::: chars(r), weight(l) + weight(r)) :: ts_).sortWith(weight(_) < weight(_))
    case _ => ts
  }

  def until[A](c: A => Boolean, f: A => A)(xs: A): A =
    if (c(xs)) xs else until(c, f)(f(xs))

  def createCodeTree(cs: List[Char]): CodeTree =
    until(singleton, combine)(makeOrderedLeafList(times(cs))).head

  // Part 3: Decoding

  type Bit = Int

  def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    def f(t: CodeTree, bs: List[Bit]): (Char, List[Bit]) =
      t match {
        case Fork(l, r, _, _) =>
          bs match {
            case 0 :: xs => f(l, xs)
            case 1 :: xs => f(r, xs)
            case _ => throw new IllegalArgumentException("Incomplete bit sequence")
          }
        case Leaf(c, _) => (c, bs)
      }
    f(tree, bits) match {
      case (c, Nil) => List(c)
      case (c, bs) => c :: decode(tree, bs)
    }
    }

  def frenchCode = ???
  def secret = ???

  def decodedSecret: List[Char] = decode(frenchCode, secret)

  // Part 4a: Encoding using Huffman tree

  def encode(t: CodeTree)(xs: List[Char]): List[Bit] = {
    def f(v: CodeTree, c: Char): List[Bit] = v match {
      case Leaf(_, _) => Nil
      case Fork(l, r, _, _) =>
        if (chars(l) contains c) 0 :: f(l, c)
        else 1 :: f(r, c)
    }
    xs.flatMap(f(t, _))
  }

  // Part 4b: Encoding using code table

  type CodeTable = List[(Char, List[Bit])]

  def codeBits(t: CodeTable)(c: Char): List[Bit] =
    t match {
      case Nil => throw new IllegalArgumentException("No such character")
      case (x, bs) :: xs => if (x == c) bs else codeBits(xs)(c)
    }

  def convert(t: CodeTree): CodeTable = t match {
    case Fork(l, r, _, _) => mergeCodeTables(convert(l), convert(r))
    case Leaf(c, _) => List((c, Nil))
  }

  def mergeCodeTables(a: CodeTable, b: CodeTable): CodeTable = {
    def step(x: Int, p: (Char, List[Bit])): (Char, List[Bit]) = p match {
      case (c, bs) => (c, x :: bs)
    }
    a.map(step(0, _)) ::: b.map(step(1, _))
  }

  def quickEncode(t: CodeTree)(xs: List[Char]): List[Bit] = xs.flatMap(codeBits(convert(t))(_))
}
