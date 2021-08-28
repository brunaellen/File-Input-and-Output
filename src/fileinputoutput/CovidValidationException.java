package fileinputoutput;

//CovidValidationException Class inherits attributes and/or methods from Exception class through(extends keyword)
public class CovidValidationException extends Exception
{
   //Constructs a new exception with the specified errorMessage.
   //The errorMessage is used when the exception is thrown
   // via getMessage() in the parent class.
   public CovidValidationException(String errorMessage)
   {
      //super keyword call the superclass's constructor (Exception). 
      super(errorMessage);
   }//end of constructor

}//end of class

/* REFERENCE:
https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html#Exception(java.lang.String)
https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html#getMessage()
*/