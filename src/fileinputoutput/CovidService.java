package fileinputoutput;
/*
Bruna Ellen Gurgel Souza - L00157216
Assignment2

*/
//import packages containing predefined classes 

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//class that has the methods to manipulate input and output data of a file
public class CovidService
{
   //method to get the Covid details for the 5 highest counties
   public List<Covid> getUserData()
   {
      //variables
      String countyName;
      int numOfCases;
      int numOfMales;
      int numOfFemales;
      int medianAge;
      int counter = 1;
      char answer;
      List<Covid> userData = new ArrayList<>();
      Scanner keyboardIn = new Scanner(System.in);
      
      //print message
      System.out.print("Enter the Covid19 details for the 5 highest counties!\n");

      //Create 5 Covid objects
      do
      { 
         //try statement (try the block of code and catch errors)
         try
         {
            /*print message and store user's input into variables*/
            System.out.print("Entering details of county " + counter + ":\n\n");
            System.out.print("Enter County Name:");
            countyName = keyboardIn.next();
            keyboardIn.nextLine();
            System.out.print("Enter Number of Cases:");
            numOfCases = keyboardIn.nextInt();
            System.out.print("Enter Number of Males:");
            numOfMales = keyboardIn.nextInt();
            System.out.print("Enter Number of Females:");
            numOfFemales = keyboardIn.nextInt();
            System.out.print("Enter the Median Age:");
            medianAge = keyboardIn.nextInt();
         
            //create a variable to store a new Covid Object
            Covid covidCase = new Covid(countyName, numOfCases, numOfMales, numOfFemales, medianAge);
            //boolean varible that stores a method that checks input errors
            boolean validData = covidCase.validateData();
            //add Covid object to the arrayList
            userData.add(covidCase);
            //increment counter variable
            counter++;
         }//end of try
         catch(CovidValidationException e)
         {
            //Returns the errorMessage string of CovidValidationException object (e)
            System.out.println("Invalid data! " + e.getMessage());
         }//end of catch
         catch(InputMismatchException e)
         {
            //Returns the errorMessage string of CovidValidationException object (e)
            System.out.println("\nInvalid datatype, please use the correct data type! ");
            keyboardIn.next();
         }//end of catch    

      }while(counter < 6); // while loop to enter five Covid Objects 
      //return userData variable (an arrayList that contains the five Covid Objects)
      return userData;

   }//close getUserData method 
   
   //method for option 1 (View all Covid data)
   public void showAllCovidData(List<Covid> covidList)
   {
      /*for loop to go through covidList data 
      and retrieving each element of covidList, 
      assigning them to covidL variable*/
      for(Covid covidL : covidList)
      {
         System.out.println(covidL); 
      }//end of for
   }//end of showAllCovidData method
   
   //method for option 2 (View data by county)
   public Covid findCovidDataByCounty(List<Covid> covidList, String countyName)
   {
      /*for loop to go through covidList data 
      and retrieving each element of covidList, 
      assigning them to covidL variable*/
      for(Covid covidL : covidList)
      {  /*if the county Name inputted by user 
          matches a county Name stored in covidL variable
          then, print all the details(covid object) of that matched county*/
         if(countyName.equalsIgnoreCase(covidL.getCountyName()))
         {
            // return covidL 
            return covidL;
         }//end of if
      }//end of for
      //return null
      return null;
   }//end of viewCovidDataByCounty method
   
   //method for option 3 (Find county with highest number of cases)
   public Covid findHighestNumCases(List<Covid> covidList)
   {  
      //declare and assign a value to highestIncidence variable
      Covid highestIncidence = covidList.get(0);
        
      /*for loop to go through covidList data 
      and retrieving each element of covidList, 
      assigning them to covid variable*/
      for(Covid covidL : covidList) 
      {
         /*if condition - to check the covidList arrayList 
         to find the Covid object that has the highest number of cases*/
         if (highestIncidence.getNoCases() < covidL.getNoCases()) 
         {
            /*assign the Covid object that has the highest number 
            of cases to highestIncidence variable*/
            highestIncidence = covidL;
         }//end of if
      }//end of for
      
      //return highestIncidence
      return highestIncidence;
      
   }//end of findHighestNumCases method
   
   //method for option 4 (Calculate average age)
   public double calculateAverageAge(List<Covid> covidList)
   {  
      //declare variables
      int sumOfMedianAgesValues = 0;
      double averageAge;
      int numOfmedianAges = covidList.size();
      
      /*for loop to go through covidList data 
      and retrieving each element of covidList, 
      assigning them to covid variable*/
      for(Covid covidL : covidList) 
      {
         //variable to store the sum of the median ages
         sumOfMedianAgesValues += covidL.getAge();
      }//end of for
      //variable to store the result of the average age calculation
      averageAge = sumOfMedianAgesValues / numOfmedianAges;
      // return average age
      return averageAge;
   }//end of calculateAverageAge method
   
   //method for option 5 (Find % number of males and % number of females by county)
   public String findMaleAndFemalePercentByCounty(List<Covid> covidList, String countyName)
   {
      //declare variables
      double numOfFemales = 0;
      double numOfMales = 0;
      double totalNumOfPeople = 0;
      double percentageOfMales = 0;
      double percentageOfFemales = 0;
      String percentages = "";
      /*for loop to go through covidList data 
      and retrieving each element of covidList, 
      assigning them to covidL variable*/
      for(Covid covidL : covidList)
      {  /*if condition - to check if the county Name inputted by user 
          matches a county Name stored in covidL variable*/
         if(countyName.equalsIgnoreCase (covidL.getCountyName()))
         {
            //variable to store the number of females 
            numOfFemales = covidL.getNoFemales();
            //variable to store the number of Males 
            numOfMales = covidL.getNoMales();
            //variable to store the total number of people
            totalNumOfPeople = covidL.getNoCases();
            //variable to store the result of the percentage calculation (females)
            percentageOfFemales = Math.round((numOfFemales / totalNumOfPeople) * 100);
            //variable to store the result of the percentage calculation (males)
            percentageOfMales = Math.round((numOfMales / totalNumOfPeople) * 100);
            //percentage variable will store the percentages
            percentages += "The percentage of male is: "+ percentageOfMales+ "%\n";
            percentages += "The percentage of females is: "+percentageOfFemales+"%";
            //return percentages
            return percentages; 
         }//end of if
      }//end of for
      //return null
      return null;
   }//end of findMaleAndFemalePercentByCounty method
   
   //method for option 6(Write all details of the county with the lowest number of cases to new file)
   public String findLowestNumCases (List<Covid> covidList) throws IOException
   {  
      //declare variable
      String message = "";
      //declare and assign a value to lowestIncidence variable
      Covid lowestIncidence = covidList.get(0);
        
      /*for loop to go through covidList data 
      and retrieving each element of covidList, 
      assigning them to covid variable*/
      for(Covid covidL : covidList) 
      {
         /*if condition - to check the covidList arrayList 
         to find the Covid object that has the lowest number of cases*/
         if (lowestIncidence.getNoCases() > covidL.getNoCases()) 
         {
            /*assign the Covid object that has the lowest number 
            of cases to lowestIncidence variable*/
            lowestIncidence = covidL;
         }//end of if
      }//end of for
      
      //Create objects to create and write to the file
      FileOutputStream fileOutputCovidData = new FileOutputStream("LowestCases.txt");
      ObjectOutputStream osLowestNumCasesData = new ObjectOutputStream(fileOutputCovidData);
      //Write Covid object to file
      osLowestNumCasesData.writeObject(lowestIncidence);
      //variable to store a message
      message += "The county with the lowest number of cases was successfully added to the new file";
      //return message
      return message;
   }// end of findLowestNumCases method

}