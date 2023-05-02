public class WalkupTicket extends Ticket{
   public WalkupTicket(int num){//Extends from the Ticket class
      super(num);
   }
      public double getPrice(){
         price = 50;//Sets the ticket price in this case as 50
      return price;
   }
}