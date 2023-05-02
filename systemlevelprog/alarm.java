import java.util.Scanner;
public class alarm{
   public int time;
   public int ttime;
   public static void main(String[] args){
     
      alarm call =  new alarm();
      Scanner input = new Scanner(System.in);
      call.iinput(input);
      call.convert();
   }
   public void iinput(Scanner input){
      System.out.println("What time do you have to wake up at? First input will be hours, the second minutes");
      try{
       time = input.nextInt();
       ttime = input.nextInt();
      }
      catch(Exception e){
         System.out.println("Incorrect format");
         System.exit(0);
      }
      if(time>23||time<0||ttime>59||ttime<0){
         System.out.println("Incorrect format");
         iinput(input);
      }
   }
   public void convert(){
      time = time*60;
      int mintime = (time + ttime)-40;
      int moretime = mintime/60;
      int funtime = mintime%60;
      System.out.println(moretime+":" +funtime);
   }
  }