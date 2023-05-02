import java.util.ArrayList;
import java.util.Scanner;
public class duplicatesbetweenarray{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      duplicatesbetweenarray call = new duplicatesbetweenarray();
      ArrayList<Integer> arr = new ArrayList<Integer>();//An arraylist will be used to add duplicates we find to it and subsequently delete them once we have the dupes
      int[] arrone = {1,5,6,6,9,9,9,11,11,21};
      int[] arrtwo = {6,6,9,11,21,21,21,};
      call.tester(arrone,arrtwo);//This will call a dedicated method which will run both arrays through a series of test cases
      System.out.println("Please type in 1 or 2 for the solution you would like");
      int iinput = input.nextInt();
      if(iinput == 1){System.out.println("Using the inefficent bruteforce algorithm, we have the result: " + call.bruteforce(arrone, arrtwo,arr));}
      else if(iinput == 2){
         System.out.println("Using the efficent binary search algorithm, we have the result: " + call.binarysearch(arrone, arrtwo, arr) );
         
      }
      }
   public void tester(int[] arrone, int[] arrtwo){
      if(arrone.length <1 || arrtwo.length<1){
         System.out.println("Error, empty array");
      }//These two test cases check to see if the array is empty, if so it will tell the user to double check the arrays
      for(int x = 0; x<arrone.length; x++){
         if(arrone[x]<0){
            System.out.println("A value is less than 0 in array one");
            x = arrone.length;
         }
      }//Since we cant have a number that is less than 0, it will tell the user if there is a number less than 0 and have them double check the array
      for(int x = 0; x<arrtwo.length;x++){
                  if(arrtwo[x]<0){
            System.out.println("A value is less than 0 in array two");
            x = arrtwo.length;
         }
      }    
   }
   public ArrayList bruteforce(int[] arrone, int[] arrtwo, ArrayList arr){//This method will "brute force" when in actuallity is a nested linear search resulting in a O(n*m) 
      if(arrone.length<=arrtwo.length){
         //This check is used to ensure an index out of bound error does not occur
         for(int x = 0; x<arrone.length; x++){
            for(int xx = 0; xx<arrtwo.length;xx++){
               if(arrone[x] == arrtwo[xx]){
                  
                  arr.add(arrone[x]);
                  
                  
                  //The top loop will be the key while the bottom loop will search the array checking to see if there is a key within itself. If so it will populate an array list with the number
               }
            }
         }
      }
         
      //The same check happens again to make sure an index out of bound error does not occur
     if(arrtwo.length<arrone.length){
      for(int x = 0; x<arrtwo.length; x++){
         for(int xx = 0; xx<arrone.length;xx++){
            if(arrtwo[x] == arrone[xx]){
               
               arr.add(arrtwo[x]);
               
               
            }
         }
      }
     }   if(arr.size() == 0){//test case if there are no duplicates the message will print with the empty arraylist so the user isnt confused
            System.out.println("There are no duplicates");
            return(arr);
         }
          duperchecker(arr);
          return(arr);
   }
   
   public void duperchecker(ArrayList<Integer> arr){//This method will recieve the arraylist of common numbers and de duplicate the list
     
      int[] rar = new int[arr.size()];
      for(int x = 0; x<rar.length;x++){
          //The array list is converted into a static array because the arraylist is dynamic. This means it will skip numbers when a number is removed in a loop, a potential duplicate that did not get removed
         rar[x] = arr.get(x) ;
      }
      while(arr.size()>0){
         arr.remove(0);
      }//once duplicates are removed the array will be reconvered back into the same arraylist which was emptied
      arr.add(rar[0]);
      for(int x = 1; x<rar.length;x++){
         if(rar[x] != rar[x-1]){
            arr.add(rar[x]);
         }
      }
   
}
   
      
         public ArrayList binarysearch(int[] arrone, int[] arrtwo, ArrayList<Integer> arr){//This method will conduct a nested binary search which will have a O(nlogm) time complexity. 
      if(arrtwo.length<arrone.length){ //This check is used to ensure an index out of bound error does not occur
         //The top loop goes through each value of the array and uses a key. The bottom loop will run a binary search looking for the  key, if a match is found it will populate an arraylist with the value
         for(int x = 0; x<arrtwo.length;x++){
            int low = 0;
            int high = arrone.length-1;
            while(low<= high){
               int midpoint = low +(high-low)/2;
               if(arrone[midpoint] == arrtwo[x]){
                  
                  arr.add(arrtwo[x]);
                  break;
               }
                if(arrone[midpoint] < arrtwo[x]){
                  
                  low = midpoint+1;
               }
                if(arrone[midpoint] > arrtwo[x]){
               
                  high = midpoint-1;
               }
            }
         }
         
      }
      if(arrone.length<=arrtwo.length){ //This check is used to ensure an index out of bound error does not occur
         //The top loop goes through each value of the array and uses a key. The bottom loop will run a binary search looking for the  key, if a match is found it will populate an arraylist with the value
         for(int x = 0; x<arrone.length;x++){
         int low = 0;
         int high = arrtwo.length-1;
         while(low<=high){
            int midpoint = low +(high-low)/2;
            if(arrtwo[midpoint] == arrone[x]){
               arr.add(arrone[x]);
               break;
            }
            if(arrtwo[midpoint] <arrone[x]){
               low = midpoint +1;
            }
            if(arrtwo[midpoint] > arrone[x]){
               high = midpoint-1;
            }
         }
      }
      }
      if(arr.size() == 0){//test case if there are no duplicates the message will print with the empty arraylist so the user isnt confused
            System.out.println("There are no duplicates");
            return(arr);
         }

      duperchecker(arr);
      return arr;     
   }

         
      
           
   }




//For the search to run in linear time we would have to use a linear search. The linear search is what was used in the bruteforce method but it took a O(m*n) because it used a nested for loop.
//To make it O(m+n) we would have to create an empty array list and then populate it using two seperate loops that run through their respective arrays. 
//Once the loops are finished the arraylist is populated we can run a loop that will remove non duplicating numbers and then run another loop that will de duplicate the remaining duplicates.
//Doing so will result in a O(m+n) since there are no nested loops.