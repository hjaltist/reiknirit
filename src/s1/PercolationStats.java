package reiknirit.s1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hjaltisteinar on 1.9.2016.
 */
public class PercolationStats {
    private double[] thresholds;
    private int computations;

    public PercolationStats(int N, int T) {
        if (N <=0 || T <= 0)
            throw new IllegalArgumentException();

        computations = T;
        thresholds = new double[T];

        for (int i = 0; i < T; i++) {
            double count = 0.0;

            Percolation perc = new Percolation(N);

            while (!perc.percolates()) {
                int x = StdRandom.uniform(0, N);
                int y = StdRandom.uniform(0, N);

                if(!perc.isOpen(x, y)) {
                    perc.open(x, y);
                    count++;
                }
            }


            thresholds[i] = count / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLow() {
        return average(thresholds) - 1.96 * stddev() / Math.sqrt((double)computations);
    }

    public double confidenceHigh() {
        return average(thresholds) + 1.96 * stddev() / Math.sqrt((double)computations);
    }

    private double average(double[] array) {
        double sum = 0.0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static void main(String[] args) {
        System.out.println("Testing 2, 100000");
        new PercolationStats(2, 100000);
        System.out.println("Testing 200, 100");
        new PercolationStats(200, 100);
    }
}
