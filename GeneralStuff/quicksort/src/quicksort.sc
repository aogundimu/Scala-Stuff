object quicksort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Regular version of quicksort
  def sort(xs: Array[Int]) {
  	def swap(i: Int, j: Int) {
    	val t = xs(i); xs(i) = xs(j); xs(j) = t
  	}
  
		def sort1(l: Int, r: Int) {
			val pivot = xs((l + r) / 2)
			var i = l; var j = r
    	while (i <= j) {
				while (xs(i) < pivot) i += 1
				while (xs(j) > pivot) j -= 1
				if (i <= j) {
					swap(i, j)
					i += 1
					j -= 1
				}
			}
			if (l < j) sort1(l, j)
			if (j < r) sort1(i, r)
		}
		sort1(0, xs.length - 1)
  }                                               //> sort: (xs: Array[Int])Unit
  
  // Functional version of quicksort
	def fsort(xs: Array[Int]): Array[Int] = {
		   if (xs.length <= 1)
		   		xs
			 else {
					val pivot = xs(xs.length / 2)
					Array.concat(
							fsort(xs filter (pivot >)),
							xs filter (pivot ==),
							fsort(xs filter (pivot <)))
			 }
	}                                         //> fsort: (xs: Array[Int])Array[Int]
	
	// Lets do some filter stuff
	var myList = Array(1, 2, 3, 7, 77, 23, 30, 2, 22, 18)
                                                  //> myList  : Array[Int] = Array(1, 2, 3, 7, 77, 23, 30, 2, 22, 18)
	var ss = myList filter(20 <)              //> ss  : Array[Int] = Array(77, 23, 30, 22)
	var ssk = myList filter(20 >)             //> ssk  : Array[Int] = Array(1, 2, 3, 7, 2, 18)
}