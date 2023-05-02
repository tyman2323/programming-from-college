public class ParkClient{
  
   public static void main(String[] args){
      Park[] ParkArray = new Park[5];
      ParkArray[0] = new Park("CSC 1302", 78, "Circle", 5);
      ParkArray[1] = new Park("CSC 1302", 81, "Square", 6); 
      ParkArray[2] = new Park("CSC 1302", 8213, "Square", 20); 
      ParkArray[3] = new Park("CSC 1302", 811, "Square", 4); 
      ParkArray[4] = new Park("CSC 1302", 8, "Square", 1); 
      double base = 0;
      int basee = 0;
      for (int j = 0; j<ParkArray.length; j++){
         if(ParkArray[j].ParkLengthGetter() >base){
            base =ParkArray[j].ParkLengthGetter();
            basee = j;
         }
      }
      System.out.println(ParkArray[basee].ParkNameGetter());
      System.out.println(ParkArray[basee].ParkIDGetter());
      System.out.println(ParkArray[basee].ParkLengthGetter());
   }
}
