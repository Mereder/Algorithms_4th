package com.mereder.Algs_Exercise.Exercises1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 编写一个程序，计算输入文件中相等的整数对的数量
 */
public class E_08_A {
    public static void main(String[] args) {
        int a[] = new int[10000];
        int N = a.length;
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0,200);
        }
        int cnt = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N ; j++) {
                if (a[i] == a[j]) cnt++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(cnt+"triples in "+(end-start)+"ms");
    }
}
