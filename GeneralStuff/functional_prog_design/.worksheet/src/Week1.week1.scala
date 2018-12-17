package Week1

object week1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet")
  
  abstract class JSON
  case class JSeq (elems: List[JSON]) extends JSON
  case class JObj (bindings: Map[String, JSON]) extends JSON
  case class JNum (num: Double) extends JSON
  case class JStr (str: String) extends JSON
  case class JBool(b: Boolean) extends JSON
  case object JNull extends JSON;$skip(733); 
  
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
    )) )) ));System.out.println("""data  : Week1.week1.JObj = """ + $show(data ));$skip(476); 
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
  };System.out.println("""show: (json: Week1.week1.JSON)String""");$skip(86); 
  
  
  //{case "ping" => "pong"}
  val f: String => String = {case "ping" => "pong"};System.out.println("""f  : String => String = """ + $show(f ));$skip(15); val res$0 = 
  
  f("ping");System.out.println("""res0: String = """ + $show(res$0));$skip(64); 
 //This results in a match error
 //  f("abc")
  
   val N = 10;System.out.println("""N  : Int = """ + $show(N ));$skip(86); val res$1 = 
   for {
      x <- 2 to N
      y <- 2 to x
      if (x % y == 0)
    } yield (x, y);System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(72); 

    def isPrime(n: Int): Boolean = (2 until n) forall(d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(15); 

    val n = 5;System.out.println("""n  : Int = """ + $show(n ));$skip(103); val res$2 = 
    (1 until n) flatMap(i =>
       (1 until i) filter (j => isPrime(i+j)) map
         (j => (i, j)));System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(105); val res$3 = 
         
    for {
       i <- 1 until n
       j <- 1 until i
       if isPrime(i+j)
    } yield(i ,j);System.out.println("""res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$3));$skip(122); 
                                                  
     val k: PartialFunction[String, String] = { case "ping" => "pong"};System.out.println("""k  : PartialFunction[String,String] = """ + $show(k ));$skip(27); val res$4 = 
     k.isDefinedAt("ping");System.out.println("""res4: Boolean = """ + $show(res$4));$skip(27); val res$5 = 
     k.isDefinedAt("pong");System.out.println("""res5: Boolean = """ + $show(res$5));$skip(172); 
                                                  
     val z: PartialFunction[List[Int], String] = {
     		 case Nil => "one"
     		 case x :: y :: rest => "two"
     };System.out.println("""z  : PartialFunction[List[Int],String] = """ + $show(z ));$skip(38); val res$6 = 
     
     z.isDefinedAt(List(1,2,3));System.out.println("""res6: Boolean = """ + $show(res$6));$skip(194); 
     
     val w: PartialFunction[List[Int], String] = {
         case Nil => "one"
         case x :: rest =>
             rest match {
                case Nil => "two"
             }
      };System.out.println("""w  : PartialFunction[List[Int],String] = """ + $show(w ));$skip(40); val res$7 = 
      
      w.isDefinedAt(List(1,2,3));System.out.println("""res7: Boolean = """ + $show(res$7))}
         
      // w(List(1,2,3))
      
   //  abstract class List[+T] {
  //    	 def map[U](f: T=> U): LIst[U] = this match {
   //   	     case x :: xs => f(x) :: xs.map(f)
    //  	     case Nil => Nil
    //  	 }
    //  }
}
