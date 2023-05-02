///////////////////////////////////////////////////////////////////////
//Solution to Programming Project 3 homework #7                      //
//Name: Ayman Tawaalai                                               //
//Program description: A program that asks the user to guess a number//
///////////////////////////////////////////////////////////////////////
import java.util.Scanner;
public class NumberGuesser{
static int count = 0;
public static void main(String args[]){

Scanner input = new Scanner(System.in);
double number = Math.random() * 100;
number = Math.round(number);
System.out.println("Welcome to the name guessing game where you will guess a number between 1 and 100");
System.out.println("What is your guess");
double guess = input.nextDouble();

while (count < 9){

if (guess > number){
System.out.println("Too high");
count++;
 guess = input.nextDouble();
}
else if (guess < number){
System.out.println("Too low");
count++;
 guess = input.nextDouble();
}
else if (guess == number){
winner();
count = 11;
 
}

}
if(count == 9){
loser(number);
}
}
public static void winner(){
int attempt = count + 1;
System.out.println("Correct, you got it in " + attempt + " tries"); 
System.out.println("Thanks for playing"); 
}
public static void loser(double number){
System.out.println("Sorry but you lose, the correct number was " + number); 
System.out.println("Thanks for playing"); 
}
}