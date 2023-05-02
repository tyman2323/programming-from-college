public class nodetwo{
   int data, datatwo,datathree;
   public nodetwo(int x, int y, int z){
      data = x;
      datatwo = y;
      datathree = z;
   }
   public static void main(String[] args){
      nodetwo list = new nodetwo(4,5,6);
      list.datagetter();
   }
   public void datagetter(){
      System.out.println(data);
   }
}