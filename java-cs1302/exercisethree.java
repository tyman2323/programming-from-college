public class exercisethree{
public static void main(String args[]){
String ani = "cat";
String rev = "";
for (int x = ani.length()- 1; x>-1; x--){
rev = rev + ani.charAt(x);
}
System.out.println(rev);
}
}