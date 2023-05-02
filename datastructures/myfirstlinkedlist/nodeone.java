public class nodeone{
public static int data; int datatwo; int datathree;
  public nodeone(int x, int y, int z){
   this.data = x;
   this.datatwo = y;
   this.datathree  =z;
  }
   public static void main(String[] args){
      nodeone list = new nodeone(1,2,3);
      
      
   }
   public static void nodegetter(nodeone list){
      int print = list.data;
      System.out.println(print);
   }
}