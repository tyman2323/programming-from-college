import java.util.Scanner;
public class Guess{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
double number = Math.random()*10;
number = Math.round(number);
int play = 1;

while(play == 1){
System.out.println("What is your guess?");
int guess = input.nextInt();
for (int stuff = 0; guess != number; stuff++) {
int tries = 1;
if (guess< number){
System.out.println("Its a bit low, try again");
tries++;
guess = input.nextInt();
}
if (guess> number){
System.out.println("Its a bit high, try again");
tries++;
guess = input.nextInt();
}
}
if (guess == number){
System.out.print("Congrats you've got it!");
System.out.println("Play again? (Y/N)");
String response = input.nextLine();
if(response.contains("Y")){
play = 1;

}
else {
play = 0;
}
}
}
}
}