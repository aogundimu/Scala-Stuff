package Week3.discreteEventSimulator

object test {
  object sim extends Circuits with Parameters
  import sim._
  val in1, in2, sum, carry = new Wire
  halfAdder(in1, in2, sum, carry)
  probe("sum", sum)
  probe("carry", carry)

  in1.setSignal(true)
  run()

  in2.setSignal(true)
  run()

  in2.setSignal(false)
  run()
  
  def main(args: Array[String]) {
    println("I am running")
    //run()
    //println("Hello, world!") 
  }
}