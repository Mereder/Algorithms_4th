package com.mereder.Algs_Exercise.Exercises1_4;

import java.util.Scanner;

/**
 * 最遥远的一对（一维）
 * 编写一个程序，给定的一个含有N个double 值的数组a[]在其中找到一对最遥远的值：两者之差（绝对值）最大的两个数。
 * 程序在最坏情况下所需要的运行时间应该是线性级别的
 */
public class E_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double a[] = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextDouble();
        }
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }
        double value = Math.abs(max-min);
        //控制下输出
        System.out.printf("%4f\n",value);


    }
}
