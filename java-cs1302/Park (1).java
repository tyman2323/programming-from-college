public class Park{
   public String ParkName;
   public int ParkID;
   public String ParkShape;
   private double ParkLength;
   public Park(String x, int xx, String xxx, double xxxx){
      ParkName = x;
      ParkID = xx;
      ParkShape = xxx;
      ParkLength = xxxx;
   }
   public String ParkNameGetter(){
      return ParkName;
   }
   public int ParkIDGetter(){
      return ParkID;
   }
   public double ParkLengthGetter(){
      return ParkLength;
   }     
}