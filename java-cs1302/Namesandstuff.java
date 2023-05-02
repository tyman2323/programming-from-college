import java.util.Scanner;
public class Namesandstuff{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
boolean end = false;
while (end==false){
System.out.println("Please enter your first and last name seperated by a space");
String name = input.nextLine();
int space = name.indexOf(" ");
System.out.println(space);
String fname = name.substring(0,space);
String lname = name.substring(space + 1,name.length());
System.out.println("Hello their " + fname + " I have your first name as " + fname + ",which has " + fname.length() + " characters");
System.out.println("Hello again " + fname + " I have your last name as " + lname + ",which has " + lname.length() + " characters");
System.out.println("Did you know that your initials are " + fname.substring(0,1) + lname.substring(0,1) );
System.out.println("Do you wish to continue (Y) Yes or (N)No?");
String answer = input.nextLine();
answer = answer.toUpperCase();
if( answer.equals("N")){
end = true;
}
}
}
}