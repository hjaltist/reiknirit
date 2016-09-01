/**
 * Created by hjaltisteinar on 18.8.2016.
 */

package d0;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Drawing {
    public static void main(String[] args) {
        // Óli prik
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.circle(0.5, 0.8, 0.1);
        StdDraw.line(0.5, 0.7, 0.5, 0.4);
        StdDraw.setPenRadius(0.04);
        StdDraw.line(0.5, 0.6, 0.3, 0.5);
        StdDraw.line(0.5, 0.6, 0.7, 0.5);
        StdDraw.setPenRadius(0.03);
        StdDraw.line(0.5, 0.4, 0.7, 0.2);
        StdDraw.line(0.5, 0.4, 0.3, 0.2);

        // Sólin
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(1, 1, 0.3);

        // Grasið
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(0.5, 0.1, 0.5, 0.1);

        // Textinn
        StdDraw.setPenColor(StdDraw.BLACK);
        Font font = new Font("Arial", Font.ITALIC, 20);
        StdDraw.setFont(font);
        StdDraw.text(0.2, 0.9, "Will he catch the staff?");

        // Dots
        Double pos = 0.0;
        StdDraw.setPenColor(StdDraw.BLUE);
        while (pos < 1) {
            StdDraw.point(0.9, pos);
            pos += 0.1;
        }

        // Stafurinn
        StdDraw.setPenRadius(0.02);
        StdDraw.line(StdRandom.uniform(), StdRandom.uniform(), StdRandom.uniform(), StdRandom.uniform());
    }
}
