package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return  (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt("1000");
        int [] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000,1000000);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + "triples "+ time + " seconds");
    }
}
