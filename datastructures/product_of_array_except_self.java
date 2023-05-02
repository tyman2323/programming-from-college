public class product_of_array_except_self{
   public static void main(String[] args){
      int[] arr = {1,2,3,4};
      int[] rar = new int[arr.length];
      int[] rra = new int[arr.length];
      rar[0] = 1;
      rra[arr.length-1] = 1;
      for(int x =1; x<rar.length; x++){
         rar[x] = arr[x-1]*rar[x-1];
      }
      for(int x = rra.length-2;x>-1;x--){
         rra[x] = arr[x+1]*rra[x+1];
      }
      int[] finarr = new int[arr.length]; 
      for(int x = 0; x<finarr.length;x++){
         finarr[x] = rar[x] * rra[x];
         System.out.print(finarr[x] +" ");
      }
   }
}