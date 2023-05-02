import java.util.Scanner;
public class FancyMyName{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
System.out.println("What is your first and name?(please be sure to seperate each part of your name with a space)");
String name = input.nextLine();
int space = name.indexOf(" ");
String fname = name.substring(0,space);
String lname = name.substring(space,name.length());
int llname = lname.length() -1;
String inital = fname.substring(0,1) + lname.substring(0,1);
String iinital = inital + lname.charAt(0);
System.out.println("You entered the name: " + name);
System.out.println("Your first name is " + fname + " has " + fname.length() + " characters");
System.out.println("Your last name is " + lname + " has " + llname + " characters");
System.out.println("Your initials are " + inital);
}
}