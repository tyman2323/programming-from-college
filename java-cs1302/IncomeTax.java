import java.util.Scanner;
public class IncomeTax{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
int people = 0;
while (people == 0){
people = (int)(Math.random()*16);
}
for(int x = 1; x<=people; x++){
System.out.println("Please enter the taxable income ");
double income = input.nextDouble();
if(income <=750){
double taxed = (income + income * .01) - income;
double taxedd = Math.round(taxed * 100.00)/100.00;
System.out.println("The tax due is " + taxedd);
}
else if(income>750 || income <= 2500){
double taxed = (income + 7.5 + income * .02) - income;
double taxedd = Math.round(taxed * 100.00)/100.00;
System.out.println("The tax due is " + taxedd);
}
else if(income>2500 || income <= 5000){
double taxed = (income + 82.5 + income * .04) - income;
double taxedd = Math.round(taxed * 100.00)/100.00;
System.out.println("The tax due is " + taxedd);
}
else if(income>5000 || income <= 8000){
double taxed = (income + 142.5 + income * .05) - income;
double taxedd = Math.round(taxed * 100.00)/100.00;
System.out.println("The tax due is " + taxedd);
}
else if(income>8000){
double taxed = (income + 230.0 + income * .06) - income;
double taxedd = Math.round(taxed * 100.00)/100.00;
System.out.println("The tax due is " + taxedd);
System.out.println("This person has maximum value of taxes");
}
}
}
}