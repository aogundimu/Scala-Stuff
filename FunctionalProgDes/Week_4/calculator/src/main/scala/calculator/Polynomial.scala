package calculator

object Polynomial {

  /**
    * Compute the delta - formula Δ = b² - 4ac
    *
    * @param a
    * @param b
    * @param c
    * @return
    */
  def computeDelta(a: Signal[Double], b: Signal[Double],  c: Signal[Double]): Signal[Double] = {
    val delta = scala.math.pow(b(), 2) - 4 * a() * c()
    Signal(delta)
  }

  /**
    *
    * @param a
    * @param b
    * @param c
    * @param delta
    * @return
    */
  def computeSolutions(a: Signal[Double], b: Signal[Double],  c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
      Signal(delta() match {
        case del if del >= 0 => Set((-b() + scala.math.sqrt(delta())) / (2*a()), (-b() - scala.math.sqrt(delta())) / (2*a()))
        case del if del == 0 => Set(-b() / (2*a()))
        case del  => Set()
      })
  }
}
