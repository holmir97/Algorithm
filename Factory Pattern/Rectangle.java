import java.awt.Point;

public class Rectangle extends Shape{
    public Rectangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double area;
        double width = points[1].x - points[0].x;
        double height = points[1].y - points[0].y;

        area = height * width;
        if(area < 0)
            area *= (-1);

        return area;
    }
}
