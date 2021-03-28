import java.awt.*;

public class RightTriangle extends Shape {
    public RightTriangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double area;
        double width = points[1].x - points[0].x;
        double height = points[1].y - points[0].y;

        area = height * width / 2;
        if(area < 0)
            area *= (-1);

        return area;
    }
}
