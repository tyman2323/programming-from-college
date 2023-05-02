import java.util.Scanner;
public class Calculated_Known{
public static void main(String args[]){
Scanner input = new Scanner (System.in);
int x = 0;
int y = 0;
int z = 0;
double num1 = 0;
double num2 = 0;
double num3 = 0;
System.out.println("Please input a number");
num1 = input.nextDouble();
System.out.println("Please input another number");
num2 = input.nextDouble();
System.out.println("Please input the last number");
num3 = input.nextDouble();
while (num1==num2 || num1 == num3 ||num2 == num3){
while (num1 == num2){
while (num1 == num3){
System.out.println("It appears your first number and third number are the same, please change number one");
num1 = input.nextDouble();
}
System.out.println("It appears your first number and second number are the same, please change number one");
num1 = input.nextDouble();
}



}
}
}