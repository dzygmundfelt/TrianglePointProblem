package zygmundfelt.dan.trianglepointproblem;


public class Triangle {
    //TODO - maybe the Points and Lines should be stored in a List.
    Point p1;
    Point p2;
    Point p3;

    Line line1;
    Line line2;
    Line line3;

    Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        line1 = new Line(p1, p2);
        line2 = new Line(p2, p3);
        line3 = new Line(p1, p3);
    }

    public void setLine1(Line line1) {
        this.line1 = line1;
    }

    public void setLine2(Line line2) {
        this.line2 = line2;
    }

    public void setLine3(Line line3) {
        this.line3 = line3;
    }

}