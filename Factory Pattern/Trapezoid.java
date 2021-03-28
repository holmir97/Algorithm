import java.awt.*;

// 사다리꼴
public class Trapezoid extends Shape{
    public Trapezoid(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double area;

        double highWidth = points[3].x - points[0].x; //윗변
        double lowWidth = points[2].x - points[1].x; //아랫변
        double height = points[1].y - points[0].y; //높이

        if(highWidth < 0)
            highWidth *= (-1);
        if(lowWidth < 0)
            lowWidth *= (-1);

        area = (highWidth + lowWidth)*height/2;

        if(area < 0)
            area *= (-1);

        return area;
    }
}
