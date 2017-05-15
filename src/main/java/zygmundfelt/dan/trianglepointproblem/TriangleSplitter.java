package zygmundfelt.dan.trianglepointproblem;

public class TriangleSplitter {

    private Triangle triangle;
    private boolean hasHorizontalLine;
    private Line dividingLine;

    TriangleSplitter(Triangle triangle) {
        this.triangle = triangle;
        setHasHorizontalLine();
    }

    public void setHasHorizontalLine() {
        hasHorizontalLine =  triangle.line1.getSlope()
                * triangle.line2.getSlope()
                * triangle.line3.getSlope() == 0;
    }

    public void setDividingLine() {
        if(hasHorizontalLine) {
            if(triangle.p1.getY() == triangle.p2.getY()) {
                dividingLine = triangle.line1;
            } else if(triangle.p2.getY() == triangle.p3.getY()) {
                dividingLine = triangle.line2;
            } else {
                dividingLine = triangle.line3;
            }
        }

        double maxY = Math.max(triangle.p1.getY(), Math.max(triangle.p2.getY(), triangle.p3.getY()));

        if(maxY == triangle.p1.getY()) {
            //dividingLine = new Line(triangle.p1, )
        }
    }

}
