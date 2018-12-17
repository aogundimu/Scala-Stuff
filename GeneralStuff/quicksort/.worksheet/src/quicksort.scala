object quicksort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(477); 
  
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
  };System.out.println("""sort: (xs: Array[Int])Unit""");$skip(291); 
  
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
	};System.out.println("""fsort: (xs: Array[Int])Array[Int]""");$skip(87); 
	
	// Lets do some filter stuff
	var myList = Array(1, 2, 3, 7, 77, 23, 30, 2, 22, 18);System.out.println("""myList  : Array[Int] = """ + $show(myList ));$skip(30); 
	var ss = myList filter(20 <);System.out.println("""ss  : Array[Int] = """ + $show(ss ));$skip(31); 
	var ssk = myList filter(20 >);System.out.println("""ssk  : Array[Int] = """ + $show(ssk ))}
}
