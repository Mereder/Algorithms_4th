package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class E_08_B {
    public static void main(String[] args) {
        int a[] = new int[10000];
        int N = a.length;
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0,200);
        }
        int cnt = 0;
        long start = System.currentTimeMillis();
        Arrays.sort(a);
        for (int i = 0; i < N ; i++) {
            if (BinarySearch.rank(a[i],a) > i)
                cnt++;
        }
        long end = System.currentTimeMillis();
        System.out.println(cnt+"triples in "+(end-start)+"ms");
    }
}
