package fileinputoutput;
/*
Bruna Ellen Gurgel Souza - L00157216
Assignment2
*/
//import packages containing predefined classes 

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

//class to read data from a file
public class CovidFileDataReader 
{
   //method to read all covid objects
   public List<Covid> getAllCovidCases(String fileName) throws IOException, ClassNotFoundException
   {
      //create objects of (FileInputStream and ObjectInputStream) to read from a file
      FileInputStream fisReadCovidDataFile = new FileInputStream(fileName);
      ObjectInputStream osReadCovidDataFile = new ObjectInputStream(fisReadCovidDataFile);
      
      //create an object of List to store all read data(Covid objects) from the file
      //covidList variable will receive an arrayList with all covid objects 
      List<Covid> covidList = (ArrayList<Covid>) osReadCovidDataFile.readObject();
      
      //return covidList (an arrayList with all covid objects)
      return covidList;
   }//end of method
}//end of CovidFileDataReader class