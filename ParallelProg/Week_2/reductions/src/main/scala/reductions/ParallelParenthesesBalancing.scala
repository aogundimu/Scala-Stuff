package reductions

import org.scalameter._
import common._

import scala.collection.immutable.Stack

object ParallelParenthesesBalancingRunner {

  @volatile var seqResult = false

  @volatile var parResult = false

  val standardConfig = config(
    Key.exec.minWarmupRuns -> 40,
    Key.exec.maxWarmupRuns -> 80,
    Key.exec.benchRuns -> 120,
    Key.verbose -> true
  ) withWarmer(new Warmer.Default)

  def main(args: Array[String]): Unit = {
    val length = 100000000
    val chars = new Array[Char](length)
    val threshold = 10000
    val seqtime = standardConfig measure {
      seqResult = ParallelParenthesesBalancing.balance(chars)
    }
    println(s"sequential result = $seqResult")
    println(s"sequential balancing time: $seqtime ms")

    val fjtime = standardConfig measure {
      parResult = ParallelParenthesesBalancing.parBalance(chars, threshold)
    }
    println(s"parallel result = $parResult")
    println(s"parallel balancing time: $fjtime ms")
    println(s"speedup: ${seqtime / fjtime}")
  }
}

object ParallelParenthesesBalancing {

  /** Returns `true` iff the parentheses in the input `chars` are balanced.
   */
  def balance2(chars: Array[Char]): Boolean = {

    def loop(chars: List[Char], stack: Stack[Char]): Boolean = {

      if (chars.isEmpty) {
        stack.isEmpty
      } else {
        val c = chars.head
        if (c == '(') {
          stack.push(c)
          loop(chars.tail, stack)
        } else if (c == ')') {
          if (stack.isEmpty) {
            false
          } else {
            val s = stack.pop
            if (s == '(') {
              loop(chars.tail, stack)
            } else {
              false
            }
          }
        } else {
          loop(chars.tail, stack)
        }
      }
    }

    val stack = Stack[Char]()
    loop(chars.toList, stack)
  }

  def balance(chars: Array[Char]): Boolean = {

    def balanceCount(index: Int, count: Int): Int = {
      if ( count == -1 ) {
        -1
      } else if ( index == chars.length ) {
        count
      } else if ( chars(index) == '(' ) {
        balanceCount(index + 1, count + 1)
      } else if ( chars(index) == ')' ) {
        balanceCount(index + 1, count - 1)
      } else {
        balanceCount(index + 1, count)
      }
    }

    balanceCount(0, 0) == 0
  }

  /** Returns `true` iff the parentheses in the input `chars` are balanced.
   */
  def parBalance(chars: Array[Char], threshold: Int): Boolean = {

    def traverse(idx: Int, until: Int, arg1: Int, arg2: Int): (Int, Int) = {

      var min = 0
      var tot = 0

      for( current <- idx until until ) {

        if ( chars(current) == '(' ) {
          tot = tot + 1
        }

        if ( chars(current) == ')' ) {
          tot = tot - 1
        }

        if ( tot < min ) {
          min = tot
        }
      }

      (min, tot)
    }

    def reduce(from: Int, until: Int): (Int, Int) = {

      if ( until - from <= threshold ) {

        traverse(from, until, 0, 0)

      } else {
        val mid = from + (until-from)/2
        val (resLeft, resRight) = {
          parallel(reduce(from, mid), reduce(mid, until))
        }

        (Math.min(resLeft._1, resLeft._2 + resRight._1), resLeft._2 + resRight._2)
      }
    }

    reduce(0, chars.length) == (0, 0)
  }

  // For those who want more:
  // Prove that your reduction operator is associative!

}
