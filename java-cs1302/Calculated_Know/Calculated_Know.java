import java.util.Scanner;
public class Calculated_Know{
static int x = 0;
static int y =0;
static int z = 0;
static int num1 = 0;
static int num2 = 0;
static int num3 = 0;

public static void main(String args[]){
calcLargestSum();
calcMiddleNumber();
Scanner input = new Scanner (System.in);
System.out.println("Please input a number");
num1 = input.nextInt();
System.out.println("Please input another number");
num2 = input.nextInt();
System.out.println("Please input the last number");
num3 = input.nextInt();
while (num1==num2 || num1 == num3 ||num2 == num3){
while (num2 == num3){
System.out.println("It appears your second and third number are the same, please change number two");
num2 = input.nextInt();
}
while (num1 == num2){
System.out.println("It appears your first number and second number are the same, please change number one");
num1 = input.nextInt();
}
while (num1 == num3){
System.out.println("It appears your first number and third number are the same, please change number one");
num1 = input.nextInt();
}

}
System.out.println("The largest sum is" + calcLargestSum());
System.out.println("The middle number is" + calcMiddleNumber());
}
public static int calcLargestSum(){


if(num1>num2){
x = num1;
y = num2;
}
else if(num2>num1){
x = num2;
y = num1;
}
else if(num1>num3){
x = num1;
y = num3;
}
else if(num3>num1){
x = num3;
y = num1;
}
else if(num2>num3){
x = num2;
y = num3;
}
else if(num3>num2){
x=num3;
y = num2;
}
if (y<num3){
y = num3;
}
int sum = x + y;
return sum;

}
public static int calcMiddleNumber(){
if (num1>num2 && num2>num3){
z = num2;
}
else if(num2>num3 && num3>num1){
z = num3;
}
else{
z = num1;
}
return z;
}
}
