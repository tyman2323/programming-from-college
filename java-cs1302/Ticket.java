import java.util.Scanner;
public class Ticket{
   Scanner input = new Scanner(System.in);
   public int number;//These attributes will hold the number of days and the price
   public double price;
   public int days;
   public Ticket(int num){//The constructor that will be used throughout
   number = num;
   
   }
   public int getNumber(){//This will return the ticket number
      return number;
   }
   public double getPrice(){
      return price;//This will return the ticket price
   }
   public void askforprice(){
   
      System.out.println("How many days away is the game, if the game is today input 0");
      days = input.nextInt();//This will ask for the days for price assignment in the subclasses
      
   }
   public String toString(){
      String statement = "Number : " + number + ", Price: " + price;
      return statement; //The two string for the print statement 
   }
}


