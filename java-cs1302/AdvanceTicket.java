public class AdvanceTicket extends Ticket{

   public AdvanceTicket(int num){//extends from ticket
      
      super(num);
   }
      public double getPrice(){
         if(days>=10){//if it is more than 10 days the price will be set to 30
            price = 30;
      
         }
         else if(days<10&& days!=0){ //if the days are below 10 then it will be set to 40 for the price
            price = 40;
         }
      
      return price;
   }
      public int getDays(){
         return days;
      }
}