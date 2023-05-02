// 
import java.util.Scanner; 
 public class Sales 
{     public static void main(String[] args) 
    {  	
 
 	Scanner scan = new Scanner(System.in); 
   System.out.println("How many sales people?");
   
   int SALESPEOPLE = scan.nextInt();  	
   int[] sales = new int[SALESPEOPLE];  	
   int sum; 

  	for (int i=0, j=1; i<sales.length; i++,j++) 
 	    { 
 	 	System.out.print("Enter sales for salesperson " + j + ": ");  	 	sales[i] = scan.nextInt(); 
 	    } 
 
 	System.out.println("\nSalesperson   Sales");  	System.out.println("--------------------");  	sum = 0; 
 	for (int i=0,j=1; i<sales.length; i++,j++) 
 	    { 
 	 	System.out.println("     " + j + "         " + sales[i]);  	 	sum += sales[i]; 
 	    } 
 
 	System.out.println("\nTotal sales: " + sum); 
   double average = sum / sales.length;
   System.out.println("The total sales average " + average);
   int max = 0;
   int maxsalesperson = 0;
   for (int p = 0, q =1; p<sales.length; p++,q++){
   if( sales[p] > max){
   max = sales[p];
   maxsalesperson = q;
   }
   }
   System.out.println("Salesperson " + maxsalesperson + " hade the most sales with a total of " + max + " sales");
   int min = 50;
   int minsalesperson = 0;
      for (int pp = 0,qq = 1; pp<sales.length; pp++,qq++){
   if( sales[pp] < min){
   min = sales[pp];
   minsalesperson = qq;
   }
   }
   System.out.println("Salesperson " + minsalesperson + " had the least sales with a total of " + min + " sales");
   System.out.println("What is the sale limit?");
   int limit = scan.nextInt();
   int id = 0;
   for (int ppp = 0, qqq = 1; ppp<sales.length; ppp++, qqq++){
      if (sales[ppp] > limit){
      System.out.println("Salesperson "+ qqq+ " went beyond the limit with a total of " +sales[ppp]+ " sales" );
      id++;
      }
   }
   System.out.println("A total of " + id + " went beyond the limit");
    } 
} 
