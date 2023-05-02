//Colored interface
public interface Colored{
	public String getColor();
}

//Point class
public class Point {
    private int x;
private int y;

    public Point() {
        this(0, 0);
    }
    public Point(int x, int y) {
        setLocation(x, y);
    }
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point other = (Point) o;
            return x == other.x && y == other.y;
        } else {  
            return false;
        }
    }
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

