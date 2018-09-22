package com.mereder.Algs_Exercise.Exercises1_4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最接近的一堆（一维）
 * 编写一个程序，给定一个含有N个double值的数组a[] 在其中找到一对最接近的值：两者之差最小的两个数。
 * 程序在最坏的情况下所需的运行时间应该是线性级别的
 */
public class E_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double a[] = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextDouble();
        }
        Arrays.sort(a);
        double mini = 999999999;
        for (int i = 0,j = i+1; j < N; i++,j++) {
            double value = Math.abs(a[i]-a[j]);
            if ( value < mini) mini = value;
        }
        System.out.printf("%4f\n",mini);
    }
}
