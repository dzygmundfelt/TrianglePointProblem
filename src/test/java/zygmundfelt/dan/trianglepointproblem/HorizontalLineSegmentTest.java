package zygmundfelt.dan.trianglepointproblem;

import org.junit.*;

public class HorizontalLineSegmentTest {

    @Test
    public void containsTrueTest() {
        HorizontalLineSegment segment = new HorizontalLineSegment(4.0, -10.8787, 100.0);
        Point p = new Point(4.0, 4.0);

        boolean result = segment.contains(p);

        Assert.assertTrue(result);
    }

    @Test
    public void containsFalseWrongYTest() {
        HorizontalLineSegment segment = new HorizontalLineSegment(-33.3333, 0, 0.1);
        Point p = new Point(0.05, -33.3);

        boolean result = segment.contains(p);

        Assert.assertFalse(result);
    }

    @Test
    public void containsFalseOutOfXRangeTest() {
        HorizontalLineSegment segment = new HorizontalLineSegment(-33.3, 0, 0.1);
        Point p = new Point(-5.43, -33.3);

        boolean result = segment.contains(p);

        Assert.assertFalse(result);
    }

}
