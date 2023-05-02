import java.util.Scanner;
public class Blackjack_Jr{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
int x = 0;
int y = 0;
int card1 = 0;
int card2 = 0;
while ( x == 0){
System.out.println("Please input a whole number between 1 and 10");
card1 = input.nextInt();
if ( card1 > 0 && card1 < 11){
x++;
}
else{
System.out.println("Youve inputed an invalid statement");
}
}
while ( y == 0){
System.out.println("Please input a whole number between 1 and 10");
card2 = input.nextInt();
if ( card2 > 0 && card2 < 11){
y++;
}
else{
System.out.println("Youve inputed an invalid statement");
}
}
int totalcard = card1 + card2;
double house1 = Math.random() * 10;
house1 = Math.round(house1);
double house2 = Math.random() * 10;
house2 = Math.round(house2);
double totalhouse = house1 + house2;
if(totalcard > totalhouse){
System.out.println("Congrats you won");
}
else if(totalcard < totalhouse){
System.out.println("Sorry the house won");
}
else{
System.out.println("Equal");
}
}
}