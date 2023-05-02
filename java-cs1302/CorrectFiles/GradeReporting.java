////////////////////////////////////////////////
//Solution to Programming Project 3 homework#7//
//Name: Ayman Tawaalai                        //
// Lab time: Wendesday 9 AM                   //
//Program description: Reports the grade      //
////////////////////////////////////////////////

import java.util.Scanner;
public class GradeReporting{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
int check = 1;
String gradeee = "0";
int grade = 0;
while (check == 1){

System.out.println("Please input the whole number grade");
gradeee = input.nextLine();
int gradee = Integer.parseInt(gradeee);
if (gradee == 100){
grade = 10;
check++;
}
else if (gradee<100 && gradee >=90){
grade = 9;
check++;
}
else if (gradee<90 && gradee >=80){
grade = 8;
check++;
}
else if (gradee<80 && gradee >=70){
grade = 7;
check++;
}
else if (gradee<70 && gradee >=60){
grade = 6;
check++;
}
else if (gradee < 60){
check++;
}else {
System.out.println("Your input was incorrect. Please input an integer whole number of the grade please.");
}
}
switch (grade){
case 10: System.out.println("Perfect Score!");
System.exit(0);

case 9: System.out.println("Well above average, excellent!");
System.exit(0);

case 8: System.out.println("Above average, nice job!");
System.exit(0);

case 7: System.out.println("Average.");
System.exit(0);

case 6: System.out.println("Below average see instructor...");
System.exit(0);

default: System.out.println("Youre not comprehending this I see.");
System.exit(0);
}
}
}