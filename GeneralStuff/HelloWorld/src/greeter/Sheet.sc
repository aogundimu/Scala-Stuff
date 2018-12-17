package greeter

object Sheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	val x = 5                                 //> x  : Int = 5
	def increase(i: Int) = i + 1              //> increase: (i: Int)Int
	increase(x)                               //> res0: Int = 6
	
	trait MyTrait {
		def method() : Boolean = {
			return true
		}
	}
	
	object MyTrait {
		def method() : Boolean = {
			return false
		}
	}
	
	MyTrait.method()                          //> res1: Boolean = false
	
	class MyClass() extends MyTrait {
	
	}
	
	val m = new MyClass()                     //> m  : greeter.Sheet.MyClass = greeter.Sheet$$anonfun$main$1$MyClass$1@13969fb
                                                  //| e
	
	trait SomeTrait {
		def printMethod() = {
			System.out.println("I am in the method")
		}
	}
	
	class SomeClass() extends MyTrait with SomeTrait {
	
	}
	
	val c = new SomeClass                     //> c  : greeter.Sheet.SomeClass = greeter.Sheet$$anonfun$main$1$SomeClass$1@6aa
                                                  //| a5eb0
	
	c.printMethod()                           //> I am in the method
	
}