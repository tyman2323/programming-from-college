public class practice{
   public static void main(String[] args){
      int[] arr = {213,42,12,1,5,22};
      practice call = new practice();
      call.quicksort(arr, 0, arr.length-1);
      for(int x = 0; x<arr.length;x++){
         System.out.println(arr[x]);
      }
      
   }
   public void quicksort(int[] arr, int low, int high){
      if(low<high){
         int pi = partition(arr,low,high);
         quicksort(arr,low,pi-1);
         quicksort(arr,pi+1,high);
      }
   }
   public int partition(int[] arr, int low, int high){
      int pivot = arr[high];
      int i = low -1;
      for(int j = low; j<= high-1;j++){
         if(arr[j] < pivot){
            i++;
            swap(arr,i,j);
         }
      }
      swap(arr,i+1,high);
      return i+1;
   }
   public void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
   public void sort(int[] arr, int l, int r){
      if(l<r){
         int m = l + (r-l)/2;
      }
   }
   }
