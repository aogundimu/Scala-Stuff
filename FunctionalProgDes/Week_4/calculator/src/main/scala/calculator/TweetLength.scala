package calculator

object TweetLength {
  final val MaxTweetLength = 140

  /**
    * Sends a Signal indicating the number of characters left in the
    * @param tweetText
    * @return
    */
  def tweetRemainingCharsCount(tweetText: Signal[String]): Signal[Int] = {
    return Signal(MaxTweetLength - tweetLength(tweetText()))
  }

  /**
    * Returns a color Signal indicating the number of chars remaining
    * @param remainingCharsCount
    * @return
    */
  def colorForRemainingCharsCount(remainingCharsCount: Signal[Int]): Signal[String] = {
    val remCnt = remainingCharsCount()
    Signal (remCnt match {
        case rem if rem >= 15 => "green"
        case rem if rem >= 0 && rem < 15 => "orange"
        case rem if rem < 0 => "red"
      }
    )
  }

  /** Computes the length of a tweet, given its text string.
   *  This is not equivalent to text.length, as tweet lengths count the number
   *  of Unicode *code points* in the string.
   *  Note that this is still a simplified view of the reality. Full details
   *  can be found at
   *  https://dev.twitter.com/overview/api/counting-characters
   */
  private def tweetLength(text: String): Int = {
    /* This should be simply text.codePointCount(0, text.length), but it
     * is not implemented in Scala.js 0.6.2.
     */
    if (text.isEmpty) 0
    else {
      text.length - text.init.zip(text.tail).count(
          (Character.isSurrogatePair _).tupled)
    }
  }
}
