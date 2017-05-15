package zygmundfelt.dan.trianglepointproblem;

public class HorizontalLineSegment {
    double yValue;
    double xLeft;
    double xRight;

    HorizontalLineSegment(double y, double x1, double x2) {
        yValue = y;
        xLeft = Math.min(x1, x2);
        xRight = Math.max(x1, x2);
    }

    boolean contains(Point p) {
        return p.getY() == yValue && p.getX() >= xLeft && p.getX() <= xRight;
    }
}