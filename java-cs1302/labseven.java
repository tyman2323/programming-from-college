import java.util.Scanner;
public class labseven{
public static void main(String args[]){

dice();
}
public static void dice(){
Scanner scan = new Scanner(System.in);
System.out.println("Enter the number that has been rolled on your dice");
int userdie = scan.nextInt();
if (userdie > 6){
Scanner tancan = new Scanner(System.in);
System.out.println("Please enter a valid number");
userdie = tancan.nextInt();
}
if (userdie > 6){
System.out.println("You have cheated the system, goodbye.");
}
else{
int diceone = (int)(Math.random()*6)+1;
int totaldice = userdie + diceone; 
System.out.println("You're total rolled is " + totaldice);
}
}
}