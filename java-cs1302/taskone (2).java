import java.util.Scanner;
public class taskone{
public static void main(String[] args){
int n = 0;
Scanner input = new Scanner(System.in);
System.out.println("Please input a number: ");
int num = input.nextInt();
System.out.println("There are " + countDigits(num) + " digits in the number of " + num);
}
public static int countDigits(int num){
int x = 0;
int xx = 1;
while(xx<=num){
x++;
xx=xx*10;
}
return(x);
}
}