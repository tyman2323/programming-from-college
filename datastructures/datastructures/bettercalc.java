import java.util.Scanner;
import java.util.Stack;
public class bettercalc{
   public static void main(String[] args){
   bettercalc call = new bettercalc();
   
   try{
      call.first();
   }
   catch(Exception e){
      System.out.println("E");//This will handle all test cases where the input does not have proper spacing or the input does not have an operator or operand
   }
 }  
   public void first(){
      Scanner input = new Scanner(System.in);
      System.out.println("Enter in your math expression make sure there is a space in between each number and operator");
      String expression = input.nextLine();
      String[] straw = expression.split(" ");      //This method will convert the string into a string array and send it to the next array
      second(straw);
   }
   public void second(String[] straw){
      Stack<Double> operands = new Stack<Double>();
      Stack<String> operators = new Stack<String>();
      for(int x = 0; x<straw.length;x++){
      
         if(straw[x].equals("+")||straw[x].equals("-")||straw[x].equals("*")||straw[x].equals("/")){
            operators.push(straw[x]);//This will work by pushing the two operators into the stack 
            if(operators.size()>1){
               String neww = operators.pop();
               String instack = operators.pop();//this will pop the first and make it new while keeping the in stack in stack after pop
               if((instack.equals("+") && (neww.equals("+") || neww.equals("-")))){
                  double right = operands.pop();
                  double left = operands.pop();
                  double sum = left + right;                //These if and else if statements will go through each version checking to see if the operator is greater than or equal to in comparsion of the new
                  operands.push(sum);
                  operators.push(neww);
               }
               
               else if((instack.equals("-") && (neww.equals("+") || neww.equals("-")))){
                  double right = operands.pop();
                  double left = operands.pop();
                  double difference = left - right;
                  operands.push(difference);
                  operators.push(neww);
               }
               else if((instack.equals("+") && (neww.equals("*") || neww.equals("/")))){//Since a + and - in comparisson to a * or / is less than it will push them always
                  operators.push(neww);
               }
               else if((instack.equals("-") && (neww.equals("*") || neww.equals("/")))){
                  operators.push(neww);
               }
               else if((instack.equals("*") && (neww.equals("+") || neww.equals("-"))||neww.equals("*")||neww.equals("/"))){
                  double right = operands.pop();
                  double left = operands.pop();
                  double product = left * right;
                  operands.push(product);
                  operators.push(neww);
               }
               else if((instack.equals("/") && (neww.equals("+") || neww.equals("-"))||neww.equals("*")||neww.equals("/"))){
                  double right = operands.pop();
                  double left = operands.pop();
                  double quotient = left / right;
                  operands.push(quotient);
                  operators.push(neww);
               }
               
            }
         }
         else{
            double num = Double.parseDouble(straw[x]);
            operands.push(num);
         }
      }
     
      if(operands.size()!=1){
         
         if(operators.peek().equals("+")){
            double right = operands.pop();
            double left = operands.pop();
            System.out.println("here");//This will process whatever is left in the stack for the final calculation
            operators.pop();
            double sum = left + right;
            operands.push(sum);
            
         }
         else if(operators.peek().equals("-")){
            double right = operands.pop();
            double left = operands.pop();
            operators.pop();
            double difference = left - right;
            operands.push(difference);
            
         }
         else if(operators.peek().equals("*")){
            double right = operands.pop();
            double left = operands.pop();
            operators.pop();
            double product = left * right;
            operands.push(product);
            
         }
         else if(operators.peek().equals("/")){
            double right = operands.pop();
            double left = operands.pop();
           operators.pop();
            double quotient = left / right;
            operands.push(quotient);
            
         }
         
      }
     System.out.println("-------" + operands);
     System.out.println("-------" + operators);
   }
}

