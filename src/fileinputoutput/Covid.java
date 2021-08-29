package fileinputoutput;
/* Covid class to record daily covid case numbers */

import java.io.Serializable;

public class Covid implements Serializable
{
   private String countyName;
   private int noCases;
   private int noMales;
   private int noFemales;
   private int medianAge;
   
   //Constructors
   //Constructor 1 - User defined default
   public Covid()
   {
      countyName = " ";
      noCases = 0;
      noMales = 0;
      noFemales = 0;
      medianAge = 0;
   }
   
   //Constructor 2 - Parameter defined constructor
   public Covid(String county, int cases, int males, int females, int age)
   {
      countyName = county;
      noCases = cases;
      noMales = males;
      noFemales = females;
      medianAge = age;
   }
   
   //Methods
   //Set methods Mutator methods
   public void setCountyName(String county)
   {
      countyName = county;
   }
   public void setNoCases(int cases)
   {
      noCases = cases;
   }
   public void setNoMales(int males)
   {
      noMales = males;
   }
   public void setNoFemales(int females)
   {
      noFemales = females;
   }
   public void setAge(int age)
   {
      medianAge = age;
   }
   //Accessor methods
   public String getCountyName()
   {
      return countyName;
   }
   public int getNoCases()
   {
      return noCases;
   }
   public int getNoMales()
   {
      return noMales;
   }
   public int getNoFemales()
   {
      return noFemales;
   }
   public int getAge()
   {
      return medianAge;
   }
   

   public String toString()
   {
      return "County Name: " + countyName+ "\t Number of Cases: "+noCases+ " \t Number of Males: "+noMales+ 
      "\t Number of Females: "+noFemales + "\t Median Age: "+ medianAge;
   }
   
   //method to validate data.
   //checking exceptions of a Covid object!
   public boolean validateData() throws CovidValidationException
   {
      //variable boolean
      boolean isDataValid = true;
      
      //checks if the number of cases is a negative number
      if (noCases < 0) 
      {
         //variable
         isDataValid = false;
         //if the number of cases is a negative number, then throw a CovidValidationException exception
         throw new CovidValidationException("The total number of cases must be a positive number!");
      }//end of if
      
      //checks if the number of males is a negative number
      if (noMales < 0) 
      {
         //variable
         isDataValid = false;
         //if the number of males is a negative number, then throw a CovidValidationException exception
         throw new CovidValidationException("Number of males cases must be a positive number!");
      }//end of if
      //checks if the number of females is a negative number
      if (noFemales < 0) 
      {
         //variable
         isDataValid = false;
         //if the number of females is a negative number, then throw a CovidValidationException exception
         throw new CovidValidationException("Number of females cases must be a positive number!");
      }//end of if
      
      //checks if the number of the median Age is a negative number
      if (medianAge < 0) 
      {
         //variable
         isDataValid = false;
         //if the number of the median Age is a negative number, then throw a CovidValidationException exception
         throw new CovidValidationException("The median age must be a positive number!");
      }//end of if
      
      //checks if the sum of males and females is greater than the total number of cases
      if ((noMales + noFemales) > noCases) 
      {
         //variable
         isDataValid = false;
         //if the sum of males and females is greater than the total number of cases, then throw a CovidValidationException exception
         throw new CovidValidationException("Number of male cases and female cases is greater than the total number of cases");
      }//end of if
      //checks if the sum of males and females is less than the total number of cases
      if ((noMales + noFemales) < noCases) 
      {
         //variable
         isDataValid = false;
         //if the sum of males and females is less than the total number of cases, then throw a CovidValidationException exception
         throw new CovidValidationException("Number of male cases and female cases is less than the total number of cases");
      }//end of if
      //checks if the number of males is greater than the total number of cases
      if (noMales > noCases) 
      {
         //variable
         isDataValid = false;
         //if the number of males is greater than the total number of cases, then throw a CovidValidationException exception
         throw new CovidValidationException("Number of male cases: " +noMales+ " is greater than the total number of cases: "+noCases);
      }//end of if
      //checks if the number of females is greater than the total number of cases
      if (noFemales > noCases) 
      {
         //variable
         isDataValid = false;
         //if the number of females is greater than the total number of cases, then throw a CovidValidationException exception
         throw new CovidValidationException("Number of females cases: " +noFemales+ " is greater than the total number of cases: "+noCases);
      }//end of if 
      //return isDataValid value
      return isDataValid;
   }//end of validateData method
}