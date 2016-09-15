package s2;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gunnar on 15/09/16.
 */
public class Fast {

    private ArrayList<ArrayList<Point>> segments;
    private Point[] points;

    private Fast(Point[] points){
        this.points = points;
        Arrays.sort(this.points);
        segments = new ArrayList<ArrayList<Point>>();
    }

    public static void main(String[] args) {

        In in = new In();
        int n = in.readInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }

        Fast fast = new Fast(points);
    }
}
