package greeter

object Sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(11); 
	val x = 5;System.out.println("""x  : Int = """ + $show(x ));$skip(30); 
	def increase(i: Int) = i + 1;System.out.println("""increase: (i: Int)Int""");$skip(13); val res$0 = 
	increase(x)
	
	trait MyTrait {
		def method() : Boolean = {
			return true
		}
	}
	
	object MyTrait {
		def method() : Boolean = {
			return false
		}
	};System.out.println("""res0: Int = """ + $show(res$0));$skip(162); val res$1 = 
	
	MyTrait.method()
	
	class MyClass() extends MyTrait {
	
	};System.out.println("""res1: Boolean = """ + $show(res$1));$skip(67); 
	
	val m = new MyClass()
	
	trait SomeTrait {
		def printMethod() = {
			System.out.println("I am in the method")
		}
	}
	
	class SomeClass() extends MyTrait with SomeTrait {
	
	};System.out.println("""m  : greeter.Sheet.MyClass = """ + $show(m ));$skip(180); 
	
	val c = new SomeClass;System.out.println("""c  : greeter.Sheet.SomeClass = """ + $show(c ));$skip(19); 
	
	c.printMethod()}
	
}
