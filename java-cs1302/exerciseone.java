public class exerciseone{
public static void main(String args[]){
String city = "San Francisco";
int stringlen = city.length();
char firstChar = city.charAt(0);
String upperCity = city.toUpperCase();
String lowerCity = city.toLowerCase();
String firstPart = city.substring(0,3);
System.out.println (city);
System.out.println (stringlen);
System.out.println (firstChar);
System.out.println (upperCity);
System.out.println (lowerCity);
System.out.println (firstPart);
}
}