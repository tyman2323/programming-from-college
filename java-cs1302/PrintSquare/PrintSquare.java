import java.util.Scanner;
public class PrintSquare{
public static void main(String args[]){
Scanner number = new Scanner(System.in);
System.out.println("Please put in a number:");
int nnumber = number.nextInt();
int nnnumber = (nnumber)*(nnumber);

System.out.println("The square of " + nnumber + " is:" + nnnumber);
}
}