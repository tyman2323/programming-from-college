
public class Lab11{
   public static void main(String[] args){
      Cat pet = new Cat(false,"fish",4,"orange");
      System.out.println("Cat is Vegetarian? " + pet.IsVegetarian());
      System.out.println("Cat eats " + pet.eatsgetter());
      System.out.println("Cat has " + pet.NumLegsgetter() + " legs");
      System.out.println("Cat color is " + pet.color());
   }
}