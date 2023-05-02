import java.util.Scanner;

public class programtwo{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
System.out.println("What is the name?");
String name = input.nextLine();
System.out.println("What is the grade for the first assignment?");
double gradeone = input.nextDouble();
System.out.println("What is the grade for the second assignment?");
double gradetwo = input.nextDouble();
System.out.println("What is the grade for the third assignment?");
double gradethree = input.nextDouble();
double average = (gradeone + gradetwo + gradethree)/3;
System.out.println(name + "'s average grade is " + average);
}
}