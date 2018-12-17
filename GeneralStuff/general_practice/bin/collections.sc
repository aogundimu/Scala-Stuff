object collections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val array = Array(1,2,3,4,5,6)                  //> array  : Array[Int] = Array(1, 2, 3, 4, 5, 6)
  // This converts this to an array of strings
  val result = array map { _.toString }           //> result  : Array[String] = Array(1, 2, 3, 4, 5, 6)
  
}