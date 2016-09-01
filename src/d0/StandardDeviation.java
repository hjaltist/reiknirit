package d0;

/**
 * Created by hjaltisteinar on 18.8.2016.
 */

import edu.princeton.cs.algs4.StdStats;

import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        double[] myArray = new double[n];

        for (int i = 0; i < n; i++) {
            double x = reader.nextInt();
            myArray[i] = x;
        }

        System.out.format("%-10.10f%n", StdStats.stddevp(myArray));
    }
}
