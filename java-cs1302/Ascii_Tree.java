
public class Ascii_Tree{
public static void main(String args[]){
for (int row = 1; 1<=10; row++){
System.out.print("|");
System.out.println();
for (int left = 0; left <= row; left++){
System.out.print("\\");
}

for (int right = 0; right<=row; right++){
System.out.print("/");
}
}
}
}