import java.util.Scanner;
public class numberpowers{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
System.out.println("Please enter a whole number");
int n = input.nextInt();
System.out.println(n+"\t"+ n +"^2" + "\t"+ n + "^3" + "\t" + n + "^4");
//System.out.println(n+ "    " + n +"^2" + "    "+ n + "^3" + "       " + n + "^4");
for (int lines = 1; lines <= n; lines++){
//System.out.print(lines+ "    " + Math.pow(lines,2) + "    "+ Math.pow(lines,3)+ "       " + Math.pow(lines,4));
System.out.println(lines+ "\t" + Math.pow(lines,2) + "\t"+ Math.pow(lines,3)+ "\t" + Math.pow(lines,4));


}                     
}
}