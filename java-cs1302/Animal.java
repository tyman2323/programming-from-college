public class Animal{
   private boolean vegetarian;   
   private String eats;
   private int NumLegs;
   public Animal(boolean veg, String food, int legs){
      vegetarian = veg;
      eats = food;
      NumLegs = legs;
   
}
   public boolean IsVegetarian(){
      return vegetarian;
   }
   public String eatsgetter(){
      return eats;
   }
   public int NumLegsgetter(){
      return NumLegs;
   }
}