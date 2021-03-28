import java.awt.*;

public abstract class Shape {
    Point[] points;
    String type;

    public Shape(String type, Point[] points){
        this.points = points;
        this.type = type;
    }

    public abstract double calcArea();

    public String toString(){
        System.out.println(type);
        for(int i = 0; i < points.length; i++)
            System.out.println(("P["+ i + "]: " + points[i].toString()));
        System.out.println(calcArea());

        return "----------------------------------";
    }
}
