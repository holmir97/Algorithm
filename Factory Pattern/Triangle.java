import java.awt.*;

public class Triangle extends Shape{
    public Triangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double area;
        double a, b, c; //세 변의 길이
        double s; //헤론 상수

        a = Math.sqrt(((points[1].x - points[0].x)*(points[1].x - points[0].x))
            + ((points[1].y - points[0].y)*(points[1].y - points[0].y)));
        b = Math.sqrt(((points[2].x - points[1].x)*(points[2].x - points[1].x))
                + ((points[2].y - points[1].y)*(points[2].y - points[1].y)));
        c = Math.sqrt(((points[0].x - points[2].x)*(points[0].x - points[2].x))
                + ((points[0].y - points[2].y)*(points[0].y - points[2].y)));

        s = (a+b+c)/2;

        area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));

        return area;
    }
}
