/******************************************************************************
 *  Compilation:  javac InfixEvaluation.java
 *  Execution:    java InfixEvaluation arg
 *  Dependencies: Stack.java @link https://mrtan.me/post/20.html
 *  
 *  Java Infix expression Calculator.
 *
 *  % java InfixEvaluation "((1 + 2) / 2)"
 *  1.5
 * 
 ******************************************************************************/
 import java.util.Stack;
class InfixEvaluation {
    public static void main(String[] args) {
        String strArr = "((1 + 2) / 2)";

        System.out.println(calculator(strArr));
    }

    public static double calculator(String strArr) {
        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();
         String str = strArr;
        for(int x =0; x<str.length();x++) {
            if (str.trim().equals("")) {
                continue;
            }

            switch(str) {
                case "(":
                    break;
                case ")":
                    double right = operands.pop();
                    double left = operands.pop();
                    String operator = operators.pop();
                    double value = 0;
                    switch(operator) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                        }
                        operands.push(value);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(str);
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;
            }
        }

        return operands.pop();
    }
}