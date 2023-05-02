public class Cat extends Animal{
   private String color;
   public Cat(boolean veg, String food, int legs,String coolor){
   super(veg, food, legs);
   color = coolor;
   }
   public String color(){
      return color;
   }
}