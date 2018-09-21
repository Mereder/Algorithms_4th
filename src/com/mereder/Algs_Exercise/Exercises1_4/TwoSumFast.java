package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {
    public static void main(String[] args) {
        int a[] = In.readInts("E:/Algorithms_4th/data/4Kints.txt");
        StdOut.println(count(a));
    }
    public static int count(int []a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i],a) > i) cnt++;
        }
        return cnt ;
    }
}
