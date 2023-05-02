public class NBATeam{
   private String teamName;
   private int NumberofWin;
   private int NumberofLoss;
   public int vv;
   public String v;  
   public int vvv;
   public NBATeam(String s, int w, int l){
   //s = teamName;
   //w = NumberofWin;
   //l = NumberofLoss;
      teamName = s;
      NumberofWin = w;
      NumberofLoss = l;
      String v  =teamName;
      int vv = NumberofWin;
      int vvv = NumberofLoss;
      winAgame();
      lossAgame();
     }
   public void winAgame(){
      NumberofWin++;
     }
   public void lossAgame(){
      NumberofLoss++;
   }
}

