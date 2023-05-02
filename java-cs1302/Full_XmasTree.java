import java.util.Scanner;
public class Full_XmasTree{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
int row = input.nextInt();
for(int i =1; i<=row; ++i){
for(int hold = 1; hold<=row - i; hold++){
System.out.print(" ");
}
for(int ko = 0; ko!=2*i-1;ko++){
System.out.print("* ");

}
System.out.println();
}
}
}