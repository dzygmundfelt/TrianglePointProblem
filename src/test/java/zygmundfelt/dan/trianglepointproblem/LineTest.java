package zygmundfelt.dan.trianglepointproblem;

import org.junit.*;

public class LineTest {

    @Test
    public void setYInterceptNormalTest() {
        Line line1 = new Line(new Point(3.5, -12), -4.5);

        line1.setYIntercept();

        Assert.assertEquals(3.75, line1.getYIntercept(), 0.00001);
    }

    @Test
    public void setYInterceptVerticalLineTest() {
        Line line = new Line(new Point(-123.456, 45678.9), Double.POSITIVE_INFINITY);

        line.setYIntercept();

        Assert.assertTrue(Double.isNaN(line.getYIntercept()));
    }

    @Test
    public void calculateVerticalSlopeTest() {
        Line line = new Line(new Point(4.5, 8.1), new Point(4.5, -0.987654321));

        Assert.assertTrue(line.getSlope() == Double.POSITIVE_INFINITY);
    }

    @Test
    public void calculatePositiveSlopeTest() {
        Line line = new Line(new Point(0, 0), new Point(7.5, 22.5));

        Assert.assertEquals(3.0, line.getSlope(), 0.000001);
    }

    @Test
    public void calculateNegativeSlopeTest() {
        Line line = new Line(new Point(0, 0), new Point(-7.5, 22.5));

        Assert.assertEquals(-3.0, line.getSlope(), 0.000001);
    }

    @Test
    public void calculateZeroSlopeTest() {
        Line line = new Line(new Point(0, 22.5), new Point(7.5, 22.5));

        Assert.assertEquals(0.0, line.getSlope(), 0.000001);
    }

    @Test
    public void containsSimpleTrueTest() {
        Line line = new Line(new Point(0, 0), new Point(7.5, 22.5));
        Point p = new Point(3.0, 9.0);

        boolean result = line.contains(p);

        Assert.assertTrue(result);
    }

    @Test
    public void containsSimpleFalseTest() {
        Line line = new Line(new Point(0, 0), new Point(8.0, 10.1));
        Point p = new Point(9.0, -1.0);

        boolean result = line.contains(p);

        Assert.assertFalse(result);
    }

    @Test
    public void containsVerticalTrueTest() {
        Line line = new Line(new Point(0, 0), new Point(0, 22.5));
        Point p = new Point(0, -43.79465);

        boolean result = line.contains(p);

        Assert.assertTrue(result);
    }

    @Test
    public void containsVerticalFalseTest() {
        Line line = new Line(new Point(0, 0), new Point(0, 22.5));
        Point p = new Point(0.1, -43.79465);

        boolean result = line.contains(p);

        Assert.assertFalse(result);
    }

}
