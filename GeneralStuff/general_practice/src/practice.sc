object practice {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // create a List
  val mainList = List(3, 2, 1)                    //> mainList  : List[Int] = List(3, 2, 1)
  
  // re-uses mainList, costs one :: instance
	val with4 =    4 :: mainList              //> with4  : List[Int] = List(4, 3, 2, 1)
	
	// also re-uses mainList, cost one :: instance
	val with42 =   42 :: mainList             //> with42  : List[Int] = List(42, 3, 2, 1)
	
	// costs nothing as it uses the same 2::1::Nil instances as mainList
	// this yields mainList minus the first element
	val shorter =  mainList.tail              //> shorter  : List[Int] = List(2, 1)
	
	// Make a list via the companion object factory
	val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
                                                  //> days  : List[String] = List(Sunday, Monday, Tuesday, Wednesday, Thursday, Fr
                                                  //| iday, Saturday)

	// Make a list element-by-element
	val when = "AM" :: "PM" :: List()         //> when  : List[String] = List(AM, PM)

	// Pattern match
	days match {
  	case firstDay :: otherDays =>
    	println("The first day of the week is: " + firstDay)
  	case List() =>
    	println("There don't seem to be any week days.")
	}                                         //> The first day of the week is: Sunday
	
	val left = List(1,2,3)                    //> left  : List[Int] = List(1, 2, 3)
	val right = List(4,5,6)                   //> right  : List[Int] = List(4, 5, 6)
	left ++ right                             //> res0: List[Int] = List(1, 2, 3, 4, 5, 6)
	left ++: right                            //> res1: List[Int] = List(1, 2, 3, 4, 5, 6)
	
	val m_array = Array[Int]()                //> m_array  : Array[Int] = Array()
	val cp = left.copyToArray(m_array)        //> cp  : Unit = ()
	println(m_array )                         //> [I@61dc03ce
	
	// Sum of all the elements of a list
	val myList = List(3, 5, 7, 11)            //> myList  : List[Int] = List(3, 5, 7, 11)
	myList.reduce((total, cur) => total + cur)//> res2: Int = 26
	
	// Same operation as above
	def op(total: Int, cur: Int) = total + cur//> op: (total: Int, cur: Int)Int
	myList reduce op                          //> res3: Int = 26
	
	// The addition operator is passed in as an argument here.
	List("Foo", "Bar", "Buzz").reduce(_ + _)  //> res4: String = FooBarBuzz
	
	// This one passes the multiplication operator as the argument to reduce
	def factorial(x: Int) = (2 to x).reduce(_ * _)
                                                  //> factorial: (x: Int)Int
	factorial(5)                              //> res5: Int = 120
	
	// The sum of all elements in myList
	val myList2 = List(3, 5, 7, 11)           //> myList2  : List[Int] = List(3, 5, 7, 11)
	myList2.sum                               //> res6: Int = 26
	
}