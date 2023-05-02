import java.util.Scanner;
public class tasktwo{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.println("Enter your name: ");
String name = input.nextLine();
boolean real = false;
char test = 0;
for(int x = 0; x<name.length(); x++){
test =name.charAt(x);
if(test<=64 && test>32){
System.out.println("Not a real name please try again: ");
name = input.nextLine();
}

}
System.out.println("The string length of '" + name + "' is: " + name.length());
}
}

