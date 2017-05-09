package zygmundfelt.dan.trianglepointproblem;

public class HorizontalLineSegment {
    Point p1;
    Point p2;

    HorizontalLineSegment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    boolean liesOn(Point p) {
        return p.getY() == p1.getY() &&
                (p.getX() > p1.getX() && p.getX() < p2.getX() ||
                        p.getX() < p1.getX() && p.getX() > p2.getX());
    }
}