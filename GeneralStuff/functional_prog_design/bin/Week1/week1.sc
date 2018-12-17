package Week1

object week1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  abstract class JSON
  case class JSeq (elems: List[JSON]) extends JSON
  case class JObj (bindings: Map[String, JSON]) extends JSON
  case class JNum (num: Double) extends JSON
  case class JStr (str: String) extends JSON
  case class JBool(b: Boolean) extends JSON
  case object JNull extends JSON
  
  val data = JObj(Map(
  "firstName" -> JStr("John"),
  "lastName" -> JStr("Smith"),
  "address" -> JObj(Map(
    "streetAddress" -> JStr("21 2nd Street"),
    "state" -> JStr("NY"),
    "postalCode" -> JNum(10021)
  )),
  "phoneNumbers" -> JSeq(List(
    JObj(Map(
      "type" -> JStr("home"), "number" -> JStr("212 555-1234")
    )),
    JObj(Map(
      "type" -> JStr("fax"), "number" -> JStr("646 555-4567")
    )) )) ))                                      //> data  : Week1.week1.JObj = JObj(Map(firstName -> JStr(John), lastName -> JSt
                                                  //| r(Smith), address -> JObj(Map(streetAddress -> JStr(21 2nd Street), state ->
                                                  //|  JStr(NY), postalCode -> JNum(10021.0))), phoneNumbers -> JSeq(List(JObj(Map
                                                  //| (type -> JStr(home), number -> JStr(212 555-1234))), JObj(Map(type -> JStr(f
                                                  //| ax), number -> JStr(646 555-4567)))))))
    // Function to print a JSON document
    def show(json: JSON): String = json match {
    case JSeq(elems) =>
      "[" + (elems map show mkString ", ") + "]"
    case JObj(bindings) =>
      val assocs = bindings map {
        case (key, value) => "\"" + key + "\": " + show(value)
      }
      "{" + (assocs mkString ", ") + "}"
    case JNum(num) => num.toString
    case JStr(str) => "\"" + str + "\""
    case JBool(b)  => b.toString
    case JNull     => "null"
  }                                               //> show: (json: Week1.week1.JSON)String
  
  
  //{case "ping" => "pong"}
  val f: String => String = {case "ping" => "pong"}
                                                  //> f  : String => String = <function1>
  
  f("ping")                                       //> res0: String = pong
 //This results in a match error
 //  f("abc")
  
   val N = 10                                     //> N  : Int = 10
   for {
      x <- 2 to N
      y <- 2 to x
      if (x % y == 0)
    } yield (x, y)                                //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,2), (3,
                                                  //| 3), (4,2), (4,4), (5,5), (6,2), (6,3), (6,6), (7,7), (8,2), (8,4), (8,8), (
                                                  //| 9,3), (9,9), (10,2), (10,5), (10,10))

    def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean

    val n = 5                                     //> n  : Int = 5
    (1 until n) flatMap(i =>
       (1 until i) filter (j => isPrime(i+j)) map
         (j => (i, j)))                           //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3))
         
    for {
       i <- 1 until n
       j <- 1 until i
       if isPrime(i+j)
    } yield(i ,j)                                 //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3))
                                                  
     val k: PartialFunction[String, String] = { case "ping" => "pong"}
                                                  //> k  : PartialFunction[String,String] = <function1>
     k.isDefinedAt("ping")                        //> res4: Boolean = true
     k.isDefinedAt("pong")                        //> res5: Boolean = false
                                                  
     val z: PartialFunction[List[Int], String] = {
     		 case Nil => "one"
     		 case x :: y :: rest => "two"
     }                                            //> z  : PartialFunction[List[Int],String] = <function1>
     
     z.isDefinedAt(List(1,2,3))                   //> res6: Boolean = true
     
     val w: PartialFunction[List[Int], String] = {
         case Nil => "one"
         case x :: rest =>
             rest match {
                case Nil => "two"
             }
      }                                           //> w  : PartialFunction[List[Int],String] = <function1>
      
      w.isDefinedAt(List(1,2,3))                  //> res7: Boolean = true
         
      // w(List(1,2,3))
      
   //  abstract class List[+T] {
  //    	 def map[U](f: T=> U): LIst[U] = this match {
   //   	     case x :: xs => f(x) :: xs.map(f)
    //  	     case Nil => Nil
    //  	 }
    //  }
}