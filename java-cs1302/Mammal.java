public class Mammal{
   private int age;
   private double weight;
   public Mammal(float weight, int age){
      this.age = age;
      this.weight = weight;
   }
   public float getWeight(){
      float w = (float)weight;
      return w;
   }
   public int getAge(){
      return age;
   }
}