import java.util.Scanner;
import java.util.Stack;
public class calculator{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Stack<String> stuff = new Stack<String>();
      System.out.println("Input the operands and operators youd like to use in post fix form. Make sure to hit enter after each operator or operand. Once you've inputted them all, type in false to exit");
      boolean more = true;
      String asdf = "";
      try{
      do{
         String f = input.nextLine();
         if(f.equalsIgnoreCase("false") == true){//This will act as an exit for the user to quit calculations
            more = false;
         }
         else{
            stuff.add(f);
            char[] ch = stuff.peek().toCharArray();
            char cch = ch[0];//This wil be a testcase to see if the user inputed an operator or operand, if not it will print out no
            int chh = cch;
            if(chh>= 58 && cch<=127 ){
               System.out.println("no");
               break;
            }
           else if(chh>= 32 && cch<=41 ){
               System.out.println("no");
               break;
            }
            if(stuff.peek().equals("+")){
            int r = Integer.parseInt(stuff.pop());//Once the plus is inputed it will pop out two in the stack, add them, and push the sum into the stack. It will also output the sum for the user
            int l = Integer.parseInt(stuff.pop());
            stuff.push(Integer.toString(l+r));
            System.out.println(stuff.peek());
         }
            else if(stuff.peek().equals("-")){
            stuff.pop();//Once the minus is inputed it will pop out two in the stack, subtract them, and push the difference into the stack. It will also output the difference for the user
            int r = Integer.parseInt(stuff.pop());
            int l = Integer.parseInt(stuff.pop());
            stuff.push(Integer.toString(l-r));
            System.out.println(stuff.peek());

         }
            else if(stuff.peek().equals("*")){
            stuff.pop();//Once the multiplication is inputed it will pop out two in the stack, multiply them, and push the product into the stack. It will also output the product for the user
            int r = Integer.parseInt(stuff.pop());
            int l = Integer.parseInt(stuff.pop());
            stuff.push(Integer.toString(l*r));
            System.out.println(stuff.peek());

         }
            else if(stuff.peek().equals("/")){
            stuff.pop();//Once the division is inputed it will pop out two in the stack, divide them, and push the quotient into the stack. It will also output the quotient for the user
            int r = Integer.parseInt(stuff.pop());
            int l = Integer.parseInt(stuff.pop());
            stuff.push(Integer.toString(l/r));
            System.out.println(stuff.peek());

         }
         }
         
         
         
      }
      while(more == true);
      
   }
   catch(Exception e){
      System.out.println("Make sure you use the postfix format for this calculator");//This exception will be used to ensure the user is writing in postfix format
      
   }
   }
   
}

//The time and space complexity will be O(n)