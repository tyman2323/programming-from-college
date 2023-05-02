import java.util.Scanner;
public class labtwo{
   public static void main(String[] args){
      labtwo call = new labtwo();
      Scanner input = new Scanner(System.in);
      int[][] arr = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
      //System.out.println(arr[0][3]);
      System.out.println("Which solution would you like, please put in a number");
      
      int g = input.nextInt();
      if(g == 1){
         call.solutionone(arr);

      }
      else{
         call.solutiontwo(arr);
      }
   }
   public void solutionone(int[][] arr){
      int[][] aar = new int[arr.length][arr[1].length];
      for(int x = 0,y=arr.length-1; x<arr.length&&y>-1;x++,y--){
         for(int xx = 0; xx<arr[x].length; xx++){
            int vel = arr[x][xx];
            aar[xx][y] = vel;
         }
      }
      arr = aar; 
      for(int x = 0; x<aar.length; x++){
         for(int xx = 0; xx<aar[0].length;xx++){
            System.out.print(arr[x][xx] + " ");
         }
         System.out.println();
      }
  
   }
   public void solutiontwo(int[][] arr){
        int y = arr.length;
        for (int i = 0; i < y; i++){
            for (int xx = 0; xx < i; xx++){
                int temp = arr[i][xx];
                arr[i][xx] = arr[xx][i];
                arr[xx][i] = temp;
            }
        }
        for (int i = 0; i < y; i++){
            for (int xx = 0; xx < y / 2; xx++){
                int temp = arr[i][xx];
                arr[i][xx] = arr[i][y - xx - 1];
                arr[i][y - xx - 1] = temp;
            }
        } 
         for(int a = 0; a<arr.length;a++){
            for(int b = 0; b<arr[a].length;b++){
               System.out.print(arr[a][b] + " ");
            } 
            System.out.println();
         }     
   }
}