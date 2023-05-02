import java.util.Arrays;
public class search{
   public static void main(String[] args){
      int a[] = new int[10];
      for(int x = 0; x< a.length; x++){
         //double ran = Math.random() * 100;
        // int ranum = (int)ran;
         a[x] = x;
      }
      int finder  = 9;
      System.out.println(seqsearch(a,finder));
      System.out.println();
      Arrays.sort(a);
      System.out.println(binsearch(a,finder));
      System.out.println(recsearch(a,0,a.length,(0 + a.length)/2));
      
   }
   public static int seqsearch(int a[], int finder){

      for(int x = 0; x<a.length; x++){
        //System.out.println(a[x]);
        if(a[x] == finder){


            return x;
        } 


   }
         
      return -1;
}
   public static int binsearch(int a[], int finder){
      int low = 0;
      int high = a.length;
      int mid = (high +low)/2 ;
      boolean found = false;
      while(found == false){
      if(a[mid] == finder){
         return mid;
      }
      else if(a[high-1] == finder){
         return high;
      }
      else if(a[low] == finder){
         return low;
      }
      else if(finder <a[high-1] &&finder>a[mid] ){
         low  = mid;
         mid = (high + low)/2;
      }
      else if(finder>a[low]&&finder<a[mid]){
         high = mid;
         mid = (high + low)/2;
      }
     }
   
      return -1;
   }
   public static int recsearch(int a[], int one, int two, int three){
      int low = one;
      int high = two;
      int mid = three;
      int finder = 9;
      
      if(a[mid] == finder){
         return mid;
      }
      else if(a[high-1] == finder){
         return high;
      }
      else if(a[low] == finder){
         return low;
      }
      else if(finder <a[high-1] &&finder>a[mid] ){
         low  = mid;
         mid = (high + low)/2;
         int fakse = mid;
         int b[] = new int[a.length/2];
         for (int x = 0; x<high; x++){
            b[x] = a[fakse];
            fakse++;
         recsearch(b,low,high, mid);
         }
         
      }
      else if(finder>a[low]&&finder<a[mid]){
         high = mid;
         mid = (high + low)/2;
         int fakse = low;
         int b[] = new int[a.length/2];
         for (int x = 0; x<mid; x++){
            b[x] = a[fakse];
            fakse++;
         recsearch(b,low,high, mid);
         }
      }
     return -1; 
   }

}


