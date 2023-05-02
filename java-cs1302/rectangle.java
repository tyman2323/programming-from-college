public class rectangle {
    int newX;//constructor for x
    int newY;//constructor for y
    int newWidth;//constructor for width
    int newHeight;//constructor for height


    public void setFields(int newx, int newy, int newwidth, int newheight){
        newX = newx; //assigns a value to the constructor
        newY = newy; //assigns a value to the constructor
        newWidth = newwidth; //assigns a value to the constructor
        newHeight = newheight; //assigns a value to the constructor


    }
    public int getHeight(){
        return newHeight; // when this method is called it will return the value of newHeight

    }
    public int getWidth(){
        return newWidth;// when this method is called it will return the value of newWidth
    }
    public int getX(){
        return newX;// when this method is called it will return the value of getX
    }
    public int getY(){
        return newY;// when this method is called it will return the value of getY
    }
    public String toString(){
        String statement = "Rectangle[x= " + getX() + ", y= " + getY() + ", height= " + getHeight() + ", width= " +   getWidth() +"]" ; // This will create a new string, the values are called by calling the method within each return val
        return statement;// when this method is called it will return the value of the String statement
    }


}
