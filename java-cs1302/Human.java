public class Human extends Mammal{
   private double height;
   public Human(float w, int a, double h){
      super(w, a);
      height = h;
   }
   public double getHeight(){
      return height;
   }
}