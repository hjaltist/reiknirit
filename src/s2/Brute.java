package s2;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;

/**
 * Created by Gunnar on 15/09/16.
 */
public class Brute {

    private Point[] points;

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
                            Point[] thePoints =  new Point[4];
                            thePoints[0] = points[p];
                            thePoints[1] = points[q];
                            thePoints[2] = points[r];
                            thePoints[3] = points[s];
                            printResults(thePoints);
                        }
                    }
    }

    public void printResults(Point[] thePoints){

            int size = thePoints.length;
            for (int k = 0; k < size ; k++){
                Point p = thePoints[k];
                String arrow = (size == k+1 ? "" : " -> ");
                System.out.print("(" + p.x + ", " + p.y + ")" + arrow);
            }
            System.out.print("\n");
    }

    public static void main(String[] args) {

        In in = new In();
        int n = in.readInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        new Brute(points);
    }
}
