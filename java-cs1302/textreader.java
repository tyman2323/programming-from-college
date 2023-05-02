import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class textreader{
   public static void main(String[] args){
    File dafile = new File("C:/Documents/dafile.txt");  
    Scanner linereader = new Scanner(dafile);
    System.out.println(linereader.nextLine());
   }
}