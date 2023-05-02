import java.util.Scanner;
import java.util.ArrayList;
public class betterdup{
   public static void main(String[] args){
      betterdup call = new betterdup();
      Scanner input = new Scanner(System.in);
      System.out.println("How many numbers would you like to be in the array");
      
      
      int howmany = input.nextInt();
      int[] arr = new int[howmany];
      while(howmany <= 0){// this test case makes sure that the array will not be empty or have a negative array size
         System.out.println("try again with a number thats greater than or equal to one");
         howmany = input.nextInt();
      }
      for(int x = 0; x<howmany; x++){//This loop will populate the array with what the user wants 
         System.out.println("What number would you want for the " + x + " position");
         arr[x] = input.nextInt();
      }
      int leg = arr.length;
      call.quicksort(arr,0,leg-1);  //These two methods will call onto the sorter and the deduplicator
      call.deduper(arr);      
   }
   public void quicksort(int[] arr, int low, int high){//All of this is done through recurssion
      if (low < high){
        int pi = partition(arr, low, high); // establishes the partition 
        quicksort(arr, low, pi - 1);// sorts the left side
        quicksort(arr, pi + 1, high); // sorts the right side
    }
    
   }
   public int partition(int[] arr, int low, int high){
    int pivot = arr[high];//The partition method here will call on the swap array if the value checked is less than the pivot. 
    int i = (low - 1);
    for(int j = low; j <= high - 1; j++){
        if (arr[j] < pivot){
            i++;//pointer increases
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
   }
    public void swap(int[] arr, int i, int j){//This method will swap between the i and the j of the array whenever called
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
   }  
   public void deduper(int[] arr){// This method will remove duplicates in the array by converting the array into an arraylist and removing the repeats in the arraylist. After that wed convert the arraylist back to an array.
      ArrayList<Integer> rar = new ArrayList<Integer>();
      rar.add(arr[0]);
      for(int x = 1; x< arr.length; x++){
         if(arr[x] != arr[x-1]){
            rar.add(arr[x]);
         }
         
      }
      int[] aar = new int[rar.size()];
      for(int x = 0; x< rar.size(); x++){
            int hold = rar.get(x);
            aar[x] = hold;
         }
      arr = aar; 
      for(int x = 0; x< arr.length; x++){// This method will print out the sorted and dedupe array
            System.out.println(arr[x]);
         }
   } 
}
   
