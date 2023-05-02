import java.util.Stack;
public class questiontwo{
   public static void main(String args[]){
      String[] vorped = {"2","1","+","4","*"};
      Stack<String> florp = new Stack<String>();
      
      for(int x = 0; x<vorped.length;x++){
         
         florp.add(vorped[x]);
         if(vorped[x].equals("+")){
            florp.pop();
            int right = Integer.parseInt(florp.pop());
            int left = Integer.parseInt(florp.pop());
            int sum = left + right;
            florp.push(Integer.toString(sum));
         }
         if(vorped[x].equals("-")){
            florp.pop();
            int right = Integer.parseInt(florp.pop());
            int left = Integer.parseInt(florp.pop());
            int difference = left-right;
            florp.push(Integer.toString(difference));
         }
         if(vorped[x].equals("*")){
            florp.pop();
            int right = Integer.parseInt(florp.pop());
            int left = Integer.parseInt(florp.pop());
            int product = left * right;
            florp.push(Integer.toString(product));
         }
         if(vorped[x].equals("/")){
            florp.pop();
            int right = Integer.parseInt(florp.pop());
            int left = Integer.parseInt(florp.pop());
            int quotient = left / right;
            florp.push(Integer.toString(quotient));
         }
      }
      System.out.println(florp.pop());
      System.out.println("Youd hit wall after wall, not knowing why an error was occuring even if the logic was perfect.");
   }
}