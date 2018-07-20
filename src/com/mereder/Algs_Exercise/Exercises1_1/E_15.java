package com.mereder.Algs_Exercise.Exercises1_1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一个静态方法histogram() 接受一个整型数组a[] 和一个整数M为参数
 * 返回一个大小为 M 的数组，其中第i个元素的值为整数i在参数数组中出现的次数。
 * 如果a[] 中的值均在 0到M-1 之间，返回数组中的所有元素之和应该和a.length()相等。
 */
public class E_15 {
    public static int[] histogram(int[] a,int M){
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            result[a[i]]++;
        }
        return result;
    }
    public static void main(String[] args) {
        int num  = 10;
        int M = 20;
        int[] a = new  int[num];
        for (int i = 0; i < num; i++) {
            a[i] = StdRandom.uniform(0,M-1);
        }
        int[] result = histogram(a,M);
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
            System.out.println(result[i]);
        }
        System.out.println("返回数组元素相加之和为："+sum);
        System.out.println("数组a长度为："+a.length);

    }
}
