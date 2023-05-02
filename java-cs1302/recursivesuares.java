/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Ayman Tawaalai                                                                                                                              // 
// 9-11-2021                                                                                                                                   //
// recursive squares                                                                                                                          // 
//  This program will use a recursive method to get the squares of a number going down by one that are even, and then go up by one that are odd//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class recursivesuares{
public static void main(String[] args){
int n = 11; //Assigns the number to start off
int original = n; //creates an original to base off of for counting up
int count = 1;//count to split into even and odd
writeSquares(n,count, original); //calls and passes to the method

}
public static void writeSquares(int n,int count, int original){
if(count ==1){//this count will be used to count down for even numbers and square them
if(n > 0 && n%2 ==0){ //checks to see if it is even
System.out.print(n*n + " "); //squares the number
n--; //reduces the checker
writeSquares(n,count,original);
}
else if(n > 0 && n%2 !=0){ //if it is odd it will just skip the print and reduce itself

n--;
writeSquares(n,count, original);
}
else{
count++; //increases the count to move onto the odd phase

writeSquares(n,count, original);
}

}
if(count ==2){ //checks to see if it is the odd phase
if(n <= original  && n%2 ==0){ //if it is even it will just increase the n
n++;
writeSquares(n,count, original);
}
else if(n <= original && n%2 !=0){ // if it is odd it will square the number and increase it by one
System.out.print(n*n + " ");
n++;
writeSquares(n,count,original);

}
else{
count++;

System.exit(0); //end the program once all the evens and odds of the squares have been printed
}
}
}
}

