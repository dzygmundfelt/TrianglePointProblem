package zygmundfelt.dan.trianglepointproblem;

import java.util.ArrayList;

public class TriangleSplitter {

    private Triangle triangle;
    private boolean hasHorizontalLine;
    private HorizontalLineSegment dividingLine;

    TriangleSplitter(Triangle triangle) {
        this.triangle = triangle;
        setDividingLine();
    }

    public void setDividingLine() {
        if(triangle.line1.getSlope() == 0) {
            hasHorizontalLine = true;
            dividingLine = new HorizontalLineSegment(triangle.p1.getY(), triangle.p1.getX(), triangle.p2.getX());
        } else if(triangle.line2.getSlope() == 0) {
            hasHorizontalLine = true;
            dividingLine = new HorizontalLineSegment(triangle.p2.getY(), triangle.p2.getX(), triangle.p3.getX());
        } else if(triangle.line3.getSlope() == 0) {
            hasHorizontalLine = true;
            dividingLine = new HorizontalLineSegment(triangle.p1.getY(), triangle.p1.getX(), triangle.p3.getX());
        } else {
            hasHorizontalLine = false;
            createDividingLine();
        }
    }

    public void createDividingLine() {
        Point p = findMiddleYPoint();
        Line line = getLineNotContainingMiddleYPoint(p);
        dividingLine = findHLSBetweenPointAndLine(p, line);
    }

    public Line getLineNotContainingMiddleYPoint(Point p) {
        if(!triangle.line1.contains(p)) {
            return triangle.line1;
        } else if(!triangle.line2.contains(p)) {
            return triangle.line2;
        } else {
            return triangle.line3;
        }
    }


    /*
    This is an ugly helper method. Maybe there's a better way to do this using a Comparator. TODO
     */
    public Point findMiddleYPoint() {
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(triangle.p1);
        list.add(triangle.p2);
        list.add(triangle.p3);
        double maxY = Math.max(triangle.p1.getY(), Math.max(triangle.p2.getY(), triangle.p3.getY()));
        for(int i = 0; i < 3; i++) {
            if(list.get(i).getY() == maxY) {
                list.remove(i);
                break;
            }
        }
        double minY = Math.min(triangle.p1.getY(), Math.min(triangle.p2.getY(), triangle.p3.getY()));
        for(int i = 0; i < 2; i++) {
            if(list.get(i).getY() == minY) {
                list.remove(i);
                break;
            }
        }
        return list.get(0);
    }

    /*
    Returns a HorizontalLineSegment object connecting a point and a line.
     */
    public HorizontalLineSegment findHLSBetweenPointAndLine(Point point, Line line) {
        if(line.getSlope() == Double.POSITIVE_INFINITY) {
            return new HorizontalLineSegment(point.getY(), point.getX(), line.getPoint().getX());
        }
        return new HorizontalLineSegment(point.getY(), point.getX(), (point.getY() - line.getYIntercept()) / line.getSlope());
    }

}
