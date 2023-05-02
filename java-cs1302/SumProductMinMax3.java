import java.util.Scanner;

public class SumProductMinMax3{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
System.out.println("Please input int one");
int one = input.nextInt();
System.out.println("Please input int two");
int two = input.nextInt();
System.out.println("Please input int three");
int three = input.nextInt();
int sum = one + two + three;
int producut = one * two * three;
int max = one;
if( one < two){
max = two;
}
else if (two < three) {
max = three;
}
else if (three < one){
max = one;
}
int min = one;
if(one > two){
min = two;
}
else if(two > three){
min = three;
} 
else if(three > one){
min = one;
}
System.out.println("The sum is: " + sum );
System.out.println("The product is: " + producut);
System.out.println("The max is: " + max );
System.out.println("The min is: " + min );
}
}