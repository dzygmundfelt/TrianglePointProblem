package zygmundfelt.dan.trianglepointproblem;

import java.util.Comparator;

public class YValueComparator implements Comparator<Point> {

    public int compare(Point p1, Point p2) {
        if(p1.getY() < p2.getY()) {
            return -1;
        } else if(p1.getY() > p2.getY()) {
            return 1;
        } else {
            return 0;
        }
    }
}
