/*
Bruna Ellen Gurgel Souza - L00157216
Assignment2

*/

//import packages containing predefined classes 
import java.util.*;
import java.io.*;

//class to create and write to a file
public class CovidFileDataWriter
{  
   //method to create file and write to a file
   public void writeCovidObjectsToAFile (String fileName, List<Covid> covidList) throws IOException
   { 
      /*Create objects of(FileOutputStream and ObjectOutputStream) 
      to create and write to a file*/
      FileOutputStream fileOutputCovidData = new FileOutputStream(fileName);
      ObjectOutputStream objectOutputCovidData = new ObjectOutputStream(fileOutputCovidData);
            
      //Write objects to the file
      objectOutputCovidData.writeObject(covidList);
      
   }//end of method writeCovidObjectsToAFile
}//end of CovidFileDataWriter class