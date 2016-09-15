package s2;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by Gunnar on 15/09/16.
 */
public class Brute {

    private Point[] points;
    private Queue<Queue<Point>> segments = new Queue<Queue<Point>>();

    private Brute(Point[] points){
        this.points = points;
        Arrays.sort(this.points);
        findSegments();
    }

    public void findSegments(){
        
        int numberOfPoints = this.points.length;

        for(int p=0; p< numberOfPoints; p++)
            for(int q=p+1; q< numberOfPoints; q++)
                for(int r=q+1; r< numberOfPoints; r++)
                    for(int s=r+1; s< numberOfPoints; s++){
                        double pq = points[p].slopeTo(points[q]);
                        double pr = points[p].slopeTo(points[r]);
                        double ps = points[p].slopeTo(points[s]);
                        if(pq == pr && pr == ps){
                            Queue<Point> x = new Queue<Point>();
                            x.enqueue(points[p]);
                            x.enqueue(points[q]);
                            x.enqueue(points[r]);
                            x.enqueue(points[s]);
                            this.segments.enqueue(x);
                        }
                    }
    }

    public void results(){

        while (!this.segments.isEmpty()){
            Queue<Point> thePoints = this.segments.dequeue();
            int size = thePoints.size();
            for (int k = 0; k < size ; k++){
                Point p = thePoints.dequeue();
                String arrow = (size == k+1 ? "" : " -> ");
                System.out.print("(" + p.x + ", " + p.y + ")" + arrow);
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

        Brute brute = new Brute(points);
        brute.results();

    }
}
