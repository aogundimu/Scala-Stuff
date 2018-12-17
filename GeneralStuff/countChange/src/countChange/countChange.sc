package countChange

object countChange {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  println( countChange(4,List(1,2) ) )            //> 3
  println( countChange(300,List(5,10,20,50,100,200,500)) )
                                                  //> 1022
  println( countChange(301,List(5,10,20,50,100,200,500)) )
                                                  //> 0
  println( countChange(300,List(500,5,50,100,20,200,10)) )
                                                  //> 1022
  
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
  }                                               //> countChange: (money: Int, coins: List[Int])Int
}