import java.util.Scanner;
import java.util.ArrayDeque;
public class maxq{
   public static void main(String[] args){
      ArrayDeque<Integer> q = new ArrayDeque<Integer>();
      ArrayDeque<Integer> max = new ArrayDeque<Integer>();
      max.add(0);//This will create our main queue and our max queue
      Scanner input = new Scanner(System.in);
      maxq call = new maxq();
      boolean exit = false;
      System.out.println("Populate with numbers, put in any non number to exit");
      do{
         try{
         q.add(input.nextInt());
         call.maxqq(q,max);
         }
         
         catch(Exception e){//This exception will act as a test case for all inputs that are not a number. It will end the queing process and present the end queue
            exit = true;
         }
         
      }
      while(exit == false);
      if(q.isEmpty() == true){
         System.out.println("Empty, nothing to see here");
      }
      else{
      System.out.println(q);
      System.out.println(max);
      }
   }
   public void maxqq(ArrayDeque<Integer> q, ArrayDeque<Integer> max){
      if(q.getLast()>max.getLast()){//This method will check to see if the new number is greater than the tail of the max, if it is then it will remove it and replace it
         max.remove(max.getLast());
      }
      
      max.add(q.getLast());
      
   }
}

//3  2  4  1