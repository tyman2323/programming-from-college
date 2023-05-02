import java.awt.*;
//Ayman Tawaalai, 10-20-2021,yourfirstnameline, this program will create a line based on the information a person's panther id
//I tried to import the package for the drawing panel but its not working with jgrasp
public class YourFirstNameLineTest{
   public static void main(String[] args){
   Point a = new Point(2,5);//gives the points to send out
   Point b = new Point(7,8);
   YourFirstNameLine v = new YourFirstNameLine(a,b); //relates back to the constructor
   DawingPanel panel = new DrawingPanel(450, 180); //Creates the panel to draw on
   panel.setBackground(Color.WHITE);
   Gaphics g = panel.getGraphics();//will relate information back from the draw method
   
   }
}