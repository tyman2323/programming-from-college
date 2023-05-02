/*
Ayman Tawaalai
Homework 5
*/


public class payroll{
public static void main(String args[]){
final double tax = .25;
String name = "Joe";
int hours = 40;
double pay = 15.00;
double gross = pay * hours;
double deduct = gross * tax;
double netpay = gross - deduct;
System.out.println("Employee Name:             " + name);
System.out.println("Hours Worked:              " + hours);
System.out.println("Hourly Rate:               " + pay);
System.out.println("Gross Pay:                 " + gross);
System.out.println("Tax Deducted:              " + deduct);
System.out.println("Net Pay:                   " + netpay);


}
}