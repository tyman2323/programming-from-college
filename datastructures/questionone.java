import java.util.HashSet;
public class questionone{
   public static void main(String[] args){
      int[] gregory = {1,2,3,4,4,6,6,6};
      HashSet freddy = new HashSet();
      for(int x = 0; x<gregory.length;x++){
         freddy.add(gregory[x]);
      }
      System.out.println(freddy);
      System.out.println("Starting off it felt a little scary, the problems were intimidating, and algorithims were confusing.");
   }
}