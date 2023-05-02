//Ayman Tawaalai, 10-20-2021,yourfirstnameline, this program will create a line based on the information a person's panther id
import java.awt.*;

public class YourFirstNameLine{
   Point point1;
   Point point2;//Creation of the attributes for the instances for the class
   
   public YourFirstNameLine(Point a, Point b){//The constructor
      point1 = a;
      point2 = b;
   }
   public Point getStartPoint(){//This will return the starting point
      return point1;
   }
   public Point getEndPoint(){//This will return the end point
      return point2;
   }
   public String toString(){//Converts the coords into a string in the designated format
      double xofpoint1 = point1.getX();
      double yofpoint1 = point1.getY();
      double xofpoint2 = point2.getX();
      double yofpoint2 = point2.getX();
      String stinger = "[("+xofpoint1+"),("+yofpoint1+"),("+xofpoint1+"),("+yofpoint1+")]";
      return stinger;
   }
   public double getSlope(){//This method will return the slope, but if it is undefined then it will return a 0
      double xofpoint1 = point1.getX();
      double yofpoint1 = point1.getY();
      double xofpoint2 = point2.getX();
      double yofpoint2 = point2.getX();
      if(xofpoint1 == xofpoint2){
         return 0.00;
      }else{
      double slope = (yofpoint2 - yofpoint1)/(xofpoint2 -xofpoint1);
      return slope;
      }
   }
   public void draw (Graphics g){//This converts the points we get into ints and puts them into g.drawLine to create a line graphic
      double xofpoint1 = point1.getX();
      double yofpoint1 = point1.getY();
      double xofpoint2 = point2.getX();
      double yofpoint2 = point2.getX();
      int x1 = (int)xofpoint1;
      int x2 = (int)xofpoint2;
      int y1 = (int)yofpoint1;
      int y2 = (int)yofpoint2;
      g.drawLine(x1,y1,x2,y2);
   }
}

