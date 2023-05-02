import java.util.Scanner;//Imports the scanner class for input
public class taskone{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.println("How many elements are in the array?");
int elements = input.nextInt();//This will take user input for how many elements are wanted
int[] numbers = new int[elements];//Populates the int array with empty values
for (int x = 0; x<elements; x++){
System.out.println("What is the number?");//A loop used to populate those emtpy values with the corresponding elements
numbers[x] = input.nextInt();
}
minGap(numbers);//This wil call upon the minGap method
}
public static void minGap(int numbers[]){
int min = 2147483647;//Makes min the maximum int value to have the gaps smaller
for (int xx = 0; xx<numbers.length-1;xx++){
if(Math.abs(numbers[xx]-numbers[xx+1])<min){//Uses this loop to get which gap is the smallest and the if statement compares if it is smaller than the current min
min = Math.abs(numbers[xx]-numbers[xx+1]);
}
}
if(numbers.length<2){
System.out.println("The smallest gap is 0");//If the total elements are less than 2 then it will print the smallest gap is 0
}
else{
System.out.println("The smallest gap is " + min);//This will print out the smallest gap in the array
}
}
}
