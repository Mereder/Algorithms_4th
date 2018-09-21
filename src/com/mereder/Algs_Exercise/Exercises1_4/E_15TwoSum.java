package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * 2-Sum 问题的线性级别算法
 */
public class E_15TwoSum {
    public static void main(String[] args) {
        int a[] = In.readInts("E:/Algorithms_4th/data/1Kints.txt");
        Arrays.sort(a); //已排序数组
        System.out.println(count(a));
    }
    public static int count(int a[]){
        int N = a.length;
        int cnt = 0;
        int lo = 0;
        int hi = N-1;
       while(lo < hi){
           if (a[lo]+a[hi] == 0){
               cnt++;
               lo++;
               hi--;
           }
           else if (-a[lo] > a[hi] ) lo++;
           else if (-a[lo] < a[hi] ) hi--;
       }
        return cnt;
    }
}
