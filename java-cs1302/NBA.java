public class NBA{
public static void main(String[] args){
NBATeam east = new NBATeam("Heat", 0, 0);
NBATeam west = new NBATeam("Spurs", 0, 0);
   for(int x = 0; x<=3; x++){
      if(Math.random()>.5){
         east.vv++;
         east.vvv++;
      }
      else {
         west.vv++;
         west.vvv++;
      }
   }
   System.out.println("The heat won: " + east.vv + " and lost: " + east.vvv);
   System.out.println("The spurs won: " + west.vv + " and lost: " + west.vvv);
   }
}