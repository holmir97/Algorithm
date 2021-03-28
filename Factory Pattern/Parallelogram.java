import java.awt.*;

//평행사변형
public class Parallelogram extends Shape{
    public Parallelogram(String type, Point[] points) {
        super(type, points);
    }

    //면적
    @Override
    public double calcArea() {
        double area;

        double width = points[3].x - points[0].x; //너비
        double height = points[1].y - points[0].y; //높이

        area = height * width;
        if(area < 0)
            area *= (-1);

        return area;
    }
}
