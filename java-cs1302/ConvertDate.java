import java.util.Scanner;
public class ConvertDate{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
System.out.println("Please enter the date");
String baddate = input.nextLine();
int num = baddate.indexOf(" ");
int space = 0;
String monthdate = "";
for(int i = 0; i<baddate.length();i++){
if(baddate.substring(i,i+1).equals(" ")){

}
else{
space = i;
i = baddate.length();
}
}
String closedate = baddate.substring(space,baddate.length());
int daystart = 0;
monthdate = closedate.substring(0,closedate.indexOf(" "));
monthdate = monthdate.toLowerCase();
String halfmonth = monthdate.substring(1,monthdate.length());
String capitalletter = monthdate.substring(0,1);
capitalletter = capitalletter.toUpperCase();
String month = capitalletter + halfmonth;

int comma = closedate.indexOf(",");
String day =closedate.substring(comma-2,comma);

String closeyear = closedate.substring(comma,closedate.length());
int spacee = 0;
for (int iiii = closedate.indexOf(","); iiii < closedate.length(); iiii++){
if(closedate.substring(iiii,iiii+1).equals(" ")){}
else{
spacee = iiii;
iiii = closedate.length();
}
String year = closedate.substring(spacee,closedate.length());
String finalyear = year.substring(year.lastIndexOf(" ")+1,year.length());

System.out.print(day +" " + month + " "  + finalyear);
}
}
}

