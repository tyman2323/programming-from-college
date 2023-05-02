public class nest_MeNumbers{
public static void main(String args[]){
int num = 0;
for (int line = 1; line<=5; line++){
for (int nummm = 5; nummm > -1; nummm--){
System.out.print(" ");
}
for (int numm = 0; numm < line; numm++){
System.out.print( numm + " ");
}
System.out.println();
}
}
}