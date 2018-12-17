package streams

import common._

trait StringParserTerrain extends GameDef {
  /**
   * A ASCII representation of the terrain. This field should remain
   * abstract here.
   */
  val level: String

  /**
   * This method returns terrain function that represents the terrain
   * in `levelVector`. The vector contains parsed version of the `level`
   * string. For example, the following level
   * 
   *   val level =
   *     """ST
   *       |oo
   *       |oo""".stripMargin
   * 
   * is represented as
   * 
   *   Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
   *
   * The resulting function should return `true` if the position `pos` is
   * a valid position (not a '-' character) inside the terrain described
   * by `levelVector`.
   */
  def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean =
    (pos: Pos) => levelVector.lift(pos.x).getOrElse(Vector.empty[Char]).lift(pos.y).getOrElse('-') != '-'

  /**
   * This function should return the position of character `c` in the
   * terrain described by `levelVector`. You can assume that the `c`
   * appears exactly once in the terrain.
   *
   * Hint: you can use the functions `indexWhere` and / or `indexOf` of the
   * `Vector` class
   */
  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = levelVector.view.zipWithIndex.collectFirst {
    case pair if pair._1.contains(c) => Pos(pair._2, pair._1.indexOf(c))
  } getOrElse Pos(-1,-1)

  private lazy val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)

  lazy val terrain: Terrain = terrainFunction(vector)
  lazy val startPos: Pos = findChar('S', vector)
  lazy val goal: Pos = findChar('T', vector)
}