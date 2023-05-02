import java.util.Scanner;
public class RepeatedDigits{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
int exit = 1;
String test = "0";
while(exit > 0){
System.out.println("Enter a number: ");
String number = input.nextLine();
if(number.equals(test) == true){
exit = 0;
}
else{
String zero = "0";
String one = "1";String two = "2";String three = "3";String four = "4";String five = "5";String six = "6";String seven = "7";String eight = "8";String nine = "9";
int zzero = 0;int oone = 0; int ttwo = 0; int tthree = 0;int ffour = 0; int ffive =0; int ssix = 0; int sseven = 0; int eeight = 0; int nnine = 0;
int length = number.length();
for(int x = 0; x<length; x++){

if(number.substring(x).equals(zero) == true){
zzero++;
}
if(number.substring(x).equals(one) == true){
oone++;
}
if(number.substring(x).equals(two) == true){
ttwo++;
}
if(number.substring(x).equals(three) == true){
tthree++;
}
if(number.substring(x).equals(four) == true){
ffour++;
}
if(number.substring(x).equals(five) == true){
ffive++;
}
if(number.substring(x).equals(six) == true){
ssix++;
}
if(number.substring(x).equals(seven) == true){
sseven++;
}
if(number.substring(x).equals(eight) == true){
eeight++;
}
if(number.substring(x).equals(nine) == true){
nnine++;
}

}
System.out.println("  Digit:     0 1 2 3 4 5 6 7 8 9");
System.out.println("Occurences:  "+zzero + " "+ oone + " "+ ttwo + " "+ tthree + " "+ ffour+ " "+ ffive+ " "+ ssix+" "+sseven + " "+ eeight + " "+ nnine);
}
}

}

}

