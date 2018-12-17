package recfun

import scala.annotation.tailrec
import scala.collection.mutable.Stack

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    @tailrec
    def loop(end: Int, cache: Array[Int], col: Int, row: Int): Int = {
      if (row == end) {
        /* return the value */
        cache(col);
      } else {
        val arr = Array.ofDim[Int](cache.length + 1)
        for (i <- 0 until arr.length) {
          if ((i == 0) || (i == arr.length - 1)) {
            arr(i) = 1
          } else {
            arr(i) = cache(i - 1) + cache(i)
          }
        }

        loop(end, arr, col, row + 1)
      }
    }

    val a = Array.ofDim[Int](1)
    a(0) = 1
    loop(r, a, c, 0)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

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
    loop(chars, stack)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    def loop(n: Int, v: List[Int], i: Int): Int = {

      if (n < 0) {
        0
      } else if (n == 0) {
        1
      } else if ((i == v.length) && (n > 0)) {
        0
      } else {
        loop(n - v(i), v, i) + loop(n, v, i + 1)
      }
    }

    loop(money, coins, 0)
  }

}