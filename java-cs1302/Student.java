public class Student extends Human{
   private String major;
   private double gpa;
   private int creditHours;
   public Student(float w, int a, double h, String m, double g, int ch){
      super(w, a, h);
      major = m;
      gpa = g;
      creditHours = ch;
   }
   public String getMajor(){
      return major;
   }
   public double getGPA(){
      return gpa;
   }
   public String getYear(){
      if(creditHours<32){
         return "Freshman";
      }
      else if(creditHours>=32&&creditHours<64){
         return "Sophmore";
      }
      else if(creditHours>=64&&creditHours<96){
         return "Junior";
      }
      else if(creditHours>=96){
         return "Senior";
      }
      return null;
   }
}