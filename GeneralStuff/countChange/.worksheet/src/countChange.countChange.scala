package countChange

object countChange {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 
  println("Welcome to the Scala worksheet");$skip(39); 
  println( countChange(4,List(1,2) ) );$skip(59); 
  println( countChange(300,List(5,10,20,50,100,200,500)) );$skip(59); 
  println( countChange(301,List(5,10,20,50,100,200,500)) );$skip(59); 
  println( countChange(300,List(500,5,50,100,20,200,10)) );$skip(400); 
  
  def countChange(money: Int, coins: List[Int]): Int = {
  
     def loop(n: Int, v: List[Int], i:Int): Int = {
         
         if ( n < 0 ) {
            0
         } else if ( n == 0 ) {
            1
         } else if ( ( i == v.length) && (n > 0) ) {
            0
         } else {
         	  loop(n - v(i), v, i) + loop(n, v, i+1)
         }
     }
     
     loop(money, coins, 0)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""")}
}
