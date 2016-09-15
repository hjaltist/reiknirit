package s2;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gunnar on 15/09/16.
 */
public class Fast {

    private Point[] points;
    private Queue<Queue<Point>> segments;

    private Fast(Point[] points){
        this.points = points;
        segments = new Queue<Queue<Point>>();
        Arrays.sort(points);
        findSegments();
    }

    private void findSegments() {

        for (Point p : this.points){
            Arrays.sort(this.points, p.SLOPE_ORDER);
            Queue<Point> collinear = new Queue<Point>();
            collinear.enqueue(p);
            for (Point q: this.points){
                if (p == q) { continue; }

                if (p.slopeTo(q) == 0){
                    collinear.enqueue(q);
                }
            }

            if (collinear.size() > 3) {
                this.segments.enqueue(collinear);
            }
        }
    }

    public void printResults(){
        for (Queue<Point> collinear : this.segments){
            int size = collinear.size();
            int k = 0;
            while (!collinear.isEmpty()){
                Point p = collinear.dequeue();
                String arrow = (size == k+1 ? "" : " -> ");
                System.out.print("(" + p.x + ", " + p.y + ")" + arrow);
                k++;
            }

            System.out.print("\n");
        }
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
        fast.printResults();
    }
}
