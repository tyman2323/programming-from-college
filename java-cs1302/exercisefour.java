public class exercisefour{
public static void main(String args[]){
String mix = "HelloWorld";
String up = mix.substring(0,5);
String low = mix.substring(5,10);
up = up.toUpperCase();
low = low.toLowerCase();
String join = up + low;
System.out.print(join);
}
}