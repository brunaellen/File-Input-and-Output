package fileinputoutput;/*
Bruna Ellen Gurgel Souza - L00157216
Assignment2
*/

//import packages containing predefined classes 

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//class that has the main method to execute the program
public class CovidApplication 
{
   //main method to execute the program
   //the method will throws exceptions
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
      //create a object of CovidService class
      CovidService service = new CovidService();
      
      /*
       - declare top5Counties variable.
       - the variable stores the getUserData() method.
       - service.getUserData() will ask the user to insert the data of the 5 counties 
       and returns all the data inserted.
       - all the inserted data is stored in top5Counties variable.
      */
      List<Covid> top5Counties = service.getUserData();
      
      //create and write covid objects to a file through CovidFileDataWriter object and its method
      CovidFileDataWriter fileDataWriter = new CovidFileDataWriter();
      fileDataWriter.writeCovidObjectsToAFile("covidData.txt", top5Counties);
      
      //read all covid objects from a file through CovidFileDataReader object and assign them to top5Counties variable
      CovidFileDataReader fileDataReader = new CovidFileDataReader();
      //variable top5Counties stores all data retrieved from covidData.txt file
      top5Counties = fileDataReader.getAllCovidCases("covidData.txt");
      //call processUserInput() method
      processUserInput(service, top5Counties);
   }//end of main method
   
   //method to process user's input
   private static void processUserInput(CovidService service, List<Covid> top5Counties) throws IOException, ClassNotFoundException, InputMismatchException
   {
      //variables
      int choice = 0;
      Scanner keyboardIn = new Scanner(System.in);
      //variable displayMenu (concatenation +=)
      String displayMenu;
      displayMenu =  "\n Menu: "; 
      displayMenu += "\n 1. View all data";
      displayMenu += "\n 2. View data by county";
      displayMenu += "\n 3. Find county with highest number of cases";
      displayMenu += "\n 4. Calculate average age";
      displayMenu += "\n 5. Find percentage number of males and percentage number of females by county";
      displayMenu += "\n 6. Write all details of the county with the lowest number of cases to new file";
      displayMenu += "\n 0. Exit System\n";
      displayMenu += "\n Enter a number: ";
      
      //menu action:
      do 
      {
         //display menu
         System.out.println(displayMenu);
         //try statement (try the block of code and catch errors)
         try
         {
            //variable choice stores what user has inputted
            choice = keyboardIn.nextInt();
            //call method (processAction) that contains all menu actions.
            processAction(choice, service, top5Counties, keyboardIn);
         }//end of try
         catch(InputMismatchException e)
         {
            //change value of choice variable
            choice = -1;
            keyboardIn.nextLine();
            //print the message for the input mismatch exception
            System.out.println("\nInvalid datatype, please use the correct data type! ");
         }//end of catch
         
      } while (choice != 0);//while condition - to end or continue loop
   }//end of processUserInput method
   
   //method that contains all menu actions.
   public static void processAction(int choice, CovidService service, List<Covid> top5Counties, Scanner keyboardIn) throws IOException, ClassNotFoundException
   {
      //"Switch" condition to display a specific data according to the number chosen from the menu
      switch(choice)
      {
         case 1:
            //display all data
            service.showAllCovidData(top5Counties);
            break;
         
         case 2:
            //display all data by county
            keyboardIn.nextLine();
            System.out.println("Insert the county name:");
            String countyName = keyboardIn.nextLine();
            Covid countyDetails = service.findCovidDataByCounty(top5Counties, countyName);
            System.out.println(countyDetails);
            break;
         
         case 3:
            //display county with highest number of cases
            Covid highestIncidence = service.findHighestNumCases(top5Counties);
            System.out.println("County with highest number of cases is: " + highestIncidence.getCountyName() + 
            ". The total Covid cases is: " +highestIncidence.getNoCases());
            break;
         
         case 4:
            //display average age
            System.out.println("The average age based on the median age of each county is: " + service.calculateAverageAge(top5Counties));
            break;
         
         case 5:
            //display % number of males and % number of females by county
            keyboardIn.nextLine();
            System.out.println("Insert the county name:");
            String nameOfCounty = keyboardIn.nextLine();
            System.out.println(service.findMaleAndFemalePercentByCounty(top5Counties, nameOfCounty));
            break;
            
         case 6:
            /*Write all details of the county with the lowest number of cases to new file
            and display message to confirm it*/
            System.out.println(service.findLowestNumCases(top5Counties));
            break;
      
         case 0:
            //exit menu
            System.out.println("Exited menu!");
            break;
         //default message            
         default:
         System.out.println("Invalid option chosen - please re-enter");
      }//end of switch condition
   }// end of processAction method
}//end of CovidApplication class