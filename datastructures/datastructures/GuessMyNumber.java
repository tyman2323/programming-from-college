import java.util.Scanner;
class GuessMyNumber {
  public static void main(String[] args){
   System.out.println("How many numbers?");
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int min = 0;
    int max = n-1;
    
    int[] lis = new int[n];
    for(int x = 0; x<lis.length;x++){
      lis[x] = x;
    }
    System.out.println("Please think of a number between " + min + " and " + max);
    boolean found = false;
    //max = n-1;
    int mid = (max + min)/2;
    String accept;
    while(found !=true){
      System.out.println("Is your number " + mid +"(H/C/L)");
      //input.nextLine();
      accept = input.nextLine();
      if(accept.equalsIgnoreCase("c")){
        found = true;
      }
      else if(accept.equalsIgnoreCase("h")){
        max = mid;
        mid = (min +max)/2;
      }
      else if(accept.equalsIgnoreCase("l")){
        min = mid;
        mid = (max+ min)/2;
      }
    }
}
}