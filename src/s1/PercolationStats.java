package s1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by hjaltisteinar on 1.9.2016.
 */
public class PercolationStats {
    public PercolationStats(int N, int T) {
        if (N <=0 || T <= 0)
            throw new IllegalArgumentException();

        Percolation perc = new Percolation(N);

        for (int i = 0; i < T; i++) {
            perc.open(StdRandom.uniform(0, N), StdRandom.uniform(0, N));
        }


    }

    public double mean() {
        return 0;
    }

    public double stddev() {
        return 9;
    }

    public double confidenceLow() {
        return 0;
    }

    public double confidenceHigh() {
        return 0;
    }

    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(50, 50);
    }
}
