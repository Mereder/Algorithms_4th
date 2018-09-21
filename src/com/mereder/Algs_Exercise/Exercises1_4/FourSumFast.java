package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * 4-Sum问题的 N*N*N*lgN 级别的算法
 * 根据后面写的 faster 基本可以降到 N*N*N 级别
 * 需要对内层两个函数进行 lo->   <-hi
 */
public class FourSumFast {
    public static void main(String[] args) {
        int a[] = In.readInts("E:/Algorithms_4th/data/1Kints.txt");
        System.out.println(count(a));
    }
    public static int count(int a[]){
        int N = a.length;
        int cnt = 0;
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (BinarySearch.rank(-(a[i]+a[j]+a[k]),a) > k)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
