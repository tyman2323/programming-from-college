public class labsix{
public static void main(String args[]){
values();
me();
var();
PrintSheepPattern();
}
public static void values(){
int a = (101+0)/3;
double b = .000003*10000000.1;
boolean c = true&&true;
boolean d = false&&false;
boolean e = (false&&false)||(true&&true);
boolean f = (false||false) &&(true&&true);
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);


}
public static void me(){
int age = 21;
int agee = age*2;
int ageee = age*3;
int ageeee = age/2;
double gpa = 3.3;
double gpaa = gpa/2;
System.out.println("My age is " +  age);
System.out.println("Twive my age is " + agee);
System.out.println("Three times my age is " + ageee);
System.out.println("Half my age is " +ageeee);
System.out.println("My GPA is " + gpa);
System.out.println("Half my GPA is " + gpaa);
}
public static void var(){
int o = 10;
float oo = 12.5f;
String ooo = "Java Programming";
System.out.println(o);
System.out.println(oo);
System.out.println(ooo);
}
public static void PrintSheepPattern(){
System.out.println("            ,   ,");
System.out.println("             ___");
System.out.println("            (oo)");
System.out.println("  /=========//");
System.out.println(" /||@@@@@@||");
System.out.println("* ||------||");
System.out.println("  vv      vv");
System.out.println("  ''      ''");
}
}