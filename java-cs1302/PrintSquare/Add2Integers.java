import java.util.Scanner;

public class Add2Integers{
public static void main(String args[]){
Scanner pop = new Scanner(System.in);
System.out.println("What is int one?");
int one = pop.nextInt();
System.out.println("What is int two?");
int two = pop.nextInt();
int sum = one + two;
System.out.println("The total sum is " + sum);
}
}