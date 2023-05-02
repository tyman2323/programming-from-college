/////////////////////////////////////////////////////////////////////////////////////
// Ayman Tawaalai                                                                  //
// 9-11-2021                                                                       //
// recursive multiply                                                              // 
//  This program uses recursive methods to multiply two numbers without using the *//
/////////////////////////////////////////////////////////////////////////////////////
public class recursivemultiply{
public static int a = 58;//a constructor to send out
public static int b =589;// a constructor to send out
public static void main(String[] args){

int d = 0; // the empty shell that will be the end product
multiply(a, b,d); // sends the variables to the method
}
public static void multiply(int a, int b,int d){
if(b ==0){ // checks base case
System.out.println(d); //prints out the product of two numbers
}
else{ //allows for the addition process
d = a +d; //adds the last product with the a
b--; //reduces b till it reaches b case
multiply(a,b,d); //calls on itself
}
}
}