package zygmundfelt.dan.trianglepointproblem;

public class Line {
    private Point p1;
    private Point p2;
    private double slope;
    private double yIntercept;

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        setSlope();
        setYInt();
    }

    Line(Point p, double slope) {
        p1 = p;
        this.slope = slope;
        setYInt();
    }

    void setYInt() {
        if(slope != Double.POSITIVE_INFINITY) {
            yIntercept = p1.getY() - slope * p1.getX();
        }
    }

    void setSlope() {
        if(p1.getX() == p2.getX()) {
            slope = Double.POSITIVE_INFINITY;
        } else {
            slope = (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        }
    }

    double getSlope() {
        return this.slope;
    }

    boolean contains(Point p) {
        if(slope == Double.POSITIVE_INFINITY) {
            return p.getX() == p1.getX();
        }

        return p.getY() == slope * p.getX() + yIntercept;
    }
}