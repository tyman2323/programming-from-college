public class midtermqtwo{
   public static void main(String[] args){
      midtermqtwo call = new midtermqtwo();
      int[] rar = {11,21,30,40,50};
      int key = 21;
     //System.out.println(call.binarysearch(rar,0,rar.length-1,key));
      call.binarysearch(rar,0,rar.length,key);
   }
   public void binarysearch(int[] rar, int l, int r, int key){
      int mid = (r+l)/2;
      
      //while(l<r){
      //int mid = l + ((r-l)/2);
         if(rar[mid] == key){
            System.out.println(mid);
         }
         
         else if(rar[mid]<=key){
            l = mid;
            //mid = (r+l)/2;
            binarysearch(rar,l,r,key);
         }
         else if(rar[mid] > key){
            r = mid;
           // mid = (r+l)/2;
            binarysearch(rar,l,r,key);
            
         }
         
         
     // }
   

   }

}