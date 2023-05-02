////////////////////////////////////////////////////////////////////////////////////////////////
// Solution to Programming Project 3 homework #4                                             //
// Name: Ayman Tawaalai                                                                      // 
// Lab time: Wensday 9am                                                                     //
// Program Description: To create a program that uses the nested if case and the switch case //
////////////////////////////////////////////////////////////////////////////////////////////////
public class MyConversion{
public static void main(String args[]){
int grade =100;
if (grade>=50 || grade<=59){
System.out.println("You got an F");
}
else if (grade>=60 || grade<=69){
System.out.println("You got an D");
}
else if (grade>=70 || grade<=79){
System.out.println("You got an C");
}
else if (grade>=80 || grade<=89){
System.out.println("You got an B");
}
else if (grade>=90 || grade<=100){
System.out.println("You got an A");
}
else{
System.out.println("print invalid grade");
}
}
}