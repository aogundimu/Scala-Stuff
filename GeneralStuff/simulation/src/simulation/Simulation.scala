
package simulation

trait Simulation {
  /** The current simulated time */
    def currentTime: Int = ???
    /** Registers an action ‘block‘ to perform after a given delay
     *  relative to the current time */
    def afterDelay(delay: Int)(block: => Unit): Unit = ???
    /** Performs the simulation until there are no actions waiting */
    def run(): Unit = ???
}