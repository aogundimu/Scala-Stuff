package Week2

class Pouring(capacity: Vector[Int]) {
  
  // States
  type State = Vector[Int]
  
  // Initial state
  val initialState = capacity map (x => 0)
  
  // Moves - case class for each move
  trait Move
  case class Empty(glass: Int) extends Move
  case class Fill(glass: Int) extends Move
  case class Pour(from: Int, to: Int) extends Move
  
  // the glasses
  val glasses = 0 until capacity.length
  
  // The following are moves
  
  // Empty an arbitrary glass
  val moves = 
      (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
  
}