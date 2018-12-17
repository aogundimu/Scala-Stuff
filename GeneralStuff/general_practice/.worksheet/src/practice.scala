object practice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet");$skip(50); 
  // create a List
  val mainList = List(3, 2, 1);System.out.println("""mainList  : List[Int] = """ + $show(mainList ));$skip(78); 
  
  // re-uses mainList, costs one :: instance
	val with4 =    4 :: mainList;System.out.println("""with4  : List[Int] = """ + $show(with4 ));$skip(81); 
	
	// also re-uses mainList, cost one :: instance
	val with42 =   42 :: mainList;System.out.println("""with42  : List[Int] = """ + $show(with42 ));$skip(151); 
	
	// costs nothing as it uses the same 2::1::Nil instances as mainList
	// this yields mainList minus the first element
	val shorter =  mainList.tail;System.out.println("""shorter  : List[Int] = """ + $show(shorter ));$skip(146); 
	
	// Make a list via the companion object factory
	val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");System.out.println("""days  : List[String] = """ + $show(days ));$skip(71); 

	// Make a list element-by-element
	val when = "AM" :: "PM" :: List();System.out.println("""when  : List[String] = """ + $show(when ));$skip(199); 

	// Pattern match
	days match {
  	case firstDay :: otherDays =>
    	println("The first day of the week is: " + firstDay)
  	case List() =>
    	println("There don't seem to be any week days.")
	};$skip(26); 
	
	val left = List(1,2,3);System.out.println("""left  : List[Int] = """ + $show(left ));$skip(25); 
	val right = List(4,5,6);System.out.println("""right  : List[Int] = """ + $show(right ));$skip(15); val res$0 = 
	left ++ right;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
	left ++: right;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(30); 
	
	val m_array = Array[Int]();System.out.println("""m_array  : Array[Int] = """ + $show(m_array ));$skip(36); 
	val cp = left.copyToArray(m_array);System.out.println("""cp  : Unit = """ + $show(cp ));$skip(19); 
	println(m_array );$skip(72); 
	
	// Sum of all the elements of a list
	val myList = List(3, 5, 7, 11);System.out.println("""myList  : List[Int] = """ + $show(myList ));$skip(44); val res$2 = 
	myList.reduce((total, cur) => total + cur);System.out.println("""res2: Int = """ + $show(res$2));$skip(74); 
	
	// Same operation as above
	def op(total: Int, cur: Int) = total + cur;System.out.println("""op: (total: Int, cur: Int)Int""");$skip(18); val res$3 = 
	myList reduce op;System.out.println("""res3: Int = """ + $show(res$3));$skip(104); val res$4 = 
	
	// The addition operator is passed in as an argument here.
	List("Foo", "Bar", "Buzz").reduce(_ + _);System.out.println("""res4: String = """ + $show(res$4));$skip(124); 
	
	// This one passes the multiplication operator as the argument to reduce
	def factorial(x: Int) = (2 to x).reduce(_ * _);System.out.println("""factorial: (x: Int)Int""");$skip(14); val res$5 = 
	factorial(5);System.out.println("""res5: Int = """ + $show(res$5));$skip(73); 
	
	// The sum of all elements in myList
	val myList2 = List(3, 5, 7, 11);System.out.println("""myList2  : List[Int] = """ + $show(myList2 ));$skip(13); val res$6 = 
	myList2.sum;System.out.println("""res6: Int = """ + $show(res$6))}
	
}
