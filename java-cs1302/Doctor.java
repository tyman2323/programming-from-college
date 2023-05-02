public class Doctor extends Human{
   private int years;
   private String specialty;
   public Doctor(float w, int a, double h, String s, int y){
      super(w, a, h);
      years = y;
      specialty = s;
   }
   public int getYears(){
      return years;
   }
   public String getSpecialty(){
      return specialty;
   }
   public double getSalary(){
      int pays = years ;
      double salary = 40000+(pays * 5000);
      return salary;
   }

}