////////////////////////////////////////////////
//Solution to Programming Project 3 homework#7//
//Name: Ayman Tawaalai                        //
// Lab time: Wendesday 9 AM                   //
//Program description: A coin flip game       //
////////////////////////////////////////////////
import java.lang.Math;
import java.util.Scanner;
public class CoinFlip2{
public static void main(String args[]){
boolean head = false;
boolean finished = false;
Scanner input = new Scanner(System.in);
while (finished != true){
System.out.println("Heads or Tails?");
String coininput = input.nextLine();
if(coininput.equalsIgnoreCase("heads")){
head = true;
finished =true;

}
else if(coininput.equalsIgnoreCase("tails")){
finished = true;
}
else{
System.out.println("You've inputed an incorret statement");
}
}
double probability = Math.random();
if(probability > .5){
System.out.println("You've won!");
}
else if(probability < .5){
System.out.println("You've lost...");
}
else{
System.out.println("The coin landed on it's side so its a tie, everyone is a winner!");
}
}
}