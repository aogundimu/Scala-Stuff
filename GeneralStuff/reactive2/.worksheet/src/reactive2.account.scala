package reactive2

object account {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(30); 

  val acct = new BankAccount;System.out.println("""acct  : reactive2.BankAccount = """ + $show(acct ));$skip(17); 
	acct deposit 50;$skip(18); val res$0 = 
	acct withdraw 20;System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
	acct withdraw 20;System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
	acct withdraw 15;System.out.println("""res2: Int = """ + $show(res$2))}
}
