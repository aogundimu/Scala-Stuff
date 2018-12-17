
object account {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet");$skip(30); 

  val acct = new BankAccount;System.out.println("""acct  : <error> = """ + $show(acct ));$skip(17); val res$0 = 
	acct deposit 50;System.out.println("""res0: <error> = """ + $show(res$0));$skip(18); val res$1 = 
	acct withdraw 20;System.out.println("""res1: <error> = """ + $show(res$1));$skip(18); val res$2 = 
	acct withdraw 20;System.out.println("""res2: <error> = """ + $show(res$2));$skip(18); val res$3 = 
	acct withdraw 15;System.out.println("""res3: <error> = """ + $show(res$3))}
}
