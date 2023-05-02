import java.util.ArrayList;
import java.util.Scanner;
public class bestdupe{
   public static void main(String[] args){
      bestdupe call = new bestdupe();
      Scanner input = new Scanner(System.in);
      System.out.println("How many would you like in the array");
      int si = input.nextInt();
      while(si<=0){
         System.out.println("try again");
         si = input.nextInt();
      }//The amove will be a test case to make sure that if the array is empty the user must put a number of 0 
      int[] arr = new int[si];
      for(int x = 0; x<arr.length;x++){
         System.out.println("Please put a number");
         arr[x] = input.nextInt();
      }//the for loop will populate the array with user numbers
      call.sort(arr, 0, arr.length - 1);
      call.deduper(arr);
      
   }
   public void sort(int arr[], int left, int right)
    {
        if (left < right) {
            
            int mid =left+ (right-left)/2;
  
            //this method will split itself recursively untill all are in their own little sub arrays and sorted 
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
  
            
            merge(arr, left, mid, right);
        }
    }
    void merge(int arr[], int left, int mid, int right)
    {//This method will merge all the subarrays back into one sigular subarray
        
        int n = mid - left + 1;
        int nn = right - mid;
  
       //This will create two empty subs from the right and left side of teh midpoint established in the sort method 
        int lef[] = new int[n];
        int rig[] = new int[nn];
  
        //This will populate each sub 
        for (int i = 0; i < n; ++i)
            lef[i] = arr[left + i];
        for (int j = 0; j < nn; ++j)
            rig[j] = arr[mid + 1 + j];
  
        
  
        
        int i = 0;
        int j = 0;
  
        
        int k = left;
        //the while loop will merge the two subs into one almost very close sorted array
        while (i < n && j < nn) {
            if (lef[i] <= rig[j]) {
                arr[k] = lef[i];
                i++;
            }
            else {
                arr[k] = rig[j];
                j++;
            }
            k++;
        }
  
        
        while (i < n) {
            arr[k] = lef[i];
            i++;
            k++;
        }
      //If there are any elements remaining it will copy it and implant it into its respective position in the array
        
        while (j < nn) {
            arr[k] = rig[j];
            j++;
            k++;
        }
    }
   public void deduper(int[] arr){// This method will remove duplicates in the array by converting the array into an arraylist and removing the repeats in the arraylist. After that wed convert the arraylist back to an array.
      ArrayList<Integer> rar = new ArrayList<Integer>();
      rar.add(arr[0]);
      for(int x = 1; x< arr.length; x++){
         if(arr[x] != arr[x-1]){
            rar.add(arr[x]);
         }
         }
         int[] copy = new int[rar.size()];
         for(int x = 0;x <copy.length;x++){
         copy[x] = rar.get(x);
      }
      arr = copy;
      for(int x = 0;x <arr.length;x++){
         System.out.print(arr[x] + " ");
      }
         
      }
}
