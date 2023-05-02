package lab10;

import java.util.Random;
public class MultiplyClient{
   public static void main(String[] args){
           Random rand = new Random();
      Fraction[] FractionArray = new Fraction[11];
       for(int x =0; x<FractionArray.length; x++){

        // double j = Math.random()*10;
         //double v = Math.random()*10;
         int max = 10;
         int min = 1;
         int jj = rand.nextInt(max - min + 1) + min;
         int vv = rand.nextInt(max - min + 1) + min;
         FractionArray[x] = new Fraction(jj,vv);

         
       }  
       
         FractionMultiply(FractionArray);


   }
      public static void FractionMultiply(Fraction[] FractionArray){
          for(int x = 0; x<FractionArray.length -1;x++){
             
          	   System.out.println(FractionArray[x].numgetter() * FractionArray[x+1].numgetter() + "/" +FractionArray[x].dengetter() * FractionArray[x+1].dengetter());
             }
}
}
//01 12 23 34 45 56 67 78 89 910 1011
  
  
       //     System.out.println( FractionArray[x].numgetter()+ "*" + FractionArray[x+1].numgetter());
         // System.out.println( FractionArray[x].dengetter()+ "*" + FractionArray[x+1].dengetter());
        // int nn = FractionArray[x].numgetter() * FractionArray[x+1].numgetter();
         //int dd = FractionArray[x].dengetter() * FractionArray[x+1].dengetter();
         //System.out.println(nn + "/" +dd);
      
   
   
