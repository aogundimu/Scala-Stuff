

package simulation

class Wire {
  
  private var sigVal = false
    
  private var actions: List[Action] = Nil
    
    def getSignal: Boolean = sigVal
    
    def setSignal(s: Boolean): Unit =
      if (s != sigVal) {
        sigVal = s
        actions foreach (_())
      }
    
    def addAction(a: Action): Unit = {
         actions = a :: actions
         a() 
      }
}
