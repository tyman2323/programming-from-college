import java.util.Scanner;
public class Half_XmassTree{

public static void main(String args[]){
Scanner input = new Scanner(System.in);
System.out.println("How many rows?");
int innput = input.nextInt(); 
for (int i = innput; i >= 1; i--) {
for (int j = 1; j <= i; j++) {
System.out.print("* ");
}
System.out.println();
}
}
}