package zygmundfelt.dan.trianglepointproblem;


import org.junit.*;

public class PointTest {

    @Test
    public void toStringTest() {
        Point p = new Point(4.5, 5.555);
        String expected = "(4.5, 5.555)";

        String actual = p.toString();

        Assert.assertEquals(expected, actual);
    }
}
