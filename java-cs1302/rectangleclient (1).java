public class rectangleclient {
    public static void main(String[] arg){
        rectangle rec1 = new rectangle(); //This creates a new object called rec1
        rec1.setFields(8,10,10,6); //This sets the parameters for the setFields and sends it
        //rec1 is used before each method so that all the methods in the rectangle class will be connected with this main method in this rectangleclient class
        rec1.getHeight(); //This calls the method in the maid
        rec1.getWidth();//This calls the method in the maid
        rec1.getX();//This calls the method in the maid
        rec1.getY();//This calls the method in the maid
        rec1.toString();//This calls the method in the maid
        System.out.println(rec1.toString()); //This is used to print out the return of toString
    }


}
