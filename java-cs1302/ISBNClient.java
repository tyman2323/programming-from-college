//Ayman Tawaalai
//9-28-2021
//The purpose of this program is to use ISBN to check if they are valid and attain its information


import java.util.Scanner;//imports the scanner package
public class ISBNClient{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
ISBN n1 = new ISBN();//Creates the object
System.out.println("What are the digits? ");
n1.digits = input.nextLine();//recieves the digits
System.out.println("What is the symbol? ");
n1.checkSymbol = input.nextLine();//recieves the symbol
System.out.println("The ISBN is " + n1.digits + n1.checkSymbol);


}
}
