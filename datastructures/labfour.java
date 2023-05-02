import java.util.ArrayList;
public class labfour{
   public static void main(String[] args){
      int[] arr = {50,11,21,40,50,40,21,33,324,32,42,24,234,23,23,4,534,663,64,32,4312,6,4,7,72,47,247,43,625,33,3,3,3,3,3,3,3,3,3,32,2,22,2,2,3,423,432,423,23,42,34,324,5,34,7,7,347,8,658,9};
      labfour call = new labfour();
      call.sort(arr);
   }
   public void sort(int[] arr){
      if(arr.length == 0){//test case that checks wheter or not this array is empty
         System.out.println("The array is empty");
      }
      int n = arr.length;
        for (int i = 0; i < n-1; i++)//uses the bubble sort to sort the array with a big o of n^2
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }      
         anotherremover(arr);// once sorted it will call the method to remove duplicates
      }
    public void anotherremover(int[] arr){
         ArrayList<Integer> copy = new ArrayList<Integer>();// creates an empty arraylist, the array list will be used to remove duplicate values 
         copy.add(arr[0]);
         for(int x = 1; x< arr.length; x++){
            if(arr[x] != arr[x-1]){
               copy.add(arr[x]);
            }
         }
         int[] aar = new int[copy.size()];//once all values have been added to the arraylist and duplicated by the for loop above, this loop will move the values of the arraylist to an empty array of the same size
         for(int x = 0; x< aar.length; x++){
            aar[x] = copy.get(x);
            
         }
         arr = aar;//this will make the original array the non duplicate array and then print it out
         System.out.println();
         for(int x = 0; x<aar.length; x++){
         System.out.print(aar[x] +" ");
         }
      }
   }
