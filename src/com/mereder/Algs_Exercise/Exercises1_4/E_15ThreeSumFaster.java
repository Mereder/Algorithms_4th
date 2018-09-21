package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * 3-sum 问题 的平方级别算法
 */
public class E_15ThreeSumFaster {
    public static void main(String[] args) {
        int a[] = In.readInts("E:/Algorithms_4th/data/1Kints.txt");
        Arrays.sort(a);
        System.out.println(count(a));
    }
    public static int count(int a[]){
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int lo = i;
            int hi = N-1;
            while(lo < hi){
                if (a[i] + a[lo] + a[hi] == 0) {
                    cnt++;
                    lo++;
                    hi--;
                }
                else if (a[i] + a[lo] + a[hi] < 0) lo++;
                else if (a[i] + a[lo] + a[hi] > 0) hi--;
            }
        }
        return cnt;
    }
}
