public class StudentAdvanceTicket extends AdvanceTicket{
   StudentAdvanceTicket(int num){
      super(num);
      
   }
         public double getPrice(){ //if the days are geater than 10 then the price will be set to 15
         if(getDays()>=10){
            price = 15;
      
         }
         else if(getDays()<10 && days!=0){ // if the day is less than 10 then the price will be set to 20
            price = 20;
         }
      
      return price;
   }
      public String toString(){
      String statement = "Number : " + number + ", Price: " + price + "(ID Required)";
      return statement;
   }
}