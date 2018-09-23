package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac BitonicMax.java
 *  Execution:    java BitonicMax N
 *  Dependencies: StdOut.java
 *
 *  Find the maximum in a bitonic array (strictly increasing, then strictly
 *  decreasing) of size N in log N time.
 *
 *  % java BitonicMax N
 *
 ******************************************************************************/


public class BitonicMax {

    // create a bitonic array of size N
    public static int[] bitonic(int N) {
        int mid = StdRandom.uniform(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i-1] + 1 + StdRandom.uniform(9);
        }

        if (mid > 0) a[mid] = a[mid-1] + StdRandom.uniform(10) - 5;

        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i-1] - 1 - StdRandom.uniform(9);
        }

        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
        return a;
    }

    // find the index of the maximum in a bitonic subarray a[lo..hi]
    public static int max(int[] a, int lo, int hi) {
        if (hi == lo) return hi;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < a[mid + 1]) return max(a, mid+1, hi);
        if (a[mid] > a[mid + 1]) return max(a, lo, mid);
        else return mid;
    }



    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int[] a = bitonic(N);
        StdOut.println("max = " + a[max(a, 0, N-1)]);
    }
}
