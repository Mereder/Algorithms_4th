package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 设a[] b[] 均为长  数百万的整型数组。以下代码的作用是什么？有效吗？
 * Anwser：这段代码会将他们交换。效率不能再高了。
 * 因为它复制的是引用而不是需要复制数百万个元素
 */
public class E_08 {
    public static void main(String[] args) {
        int[] a = new int[10000000];
        int[] b = new int[10000000];
        int t[] = a;
        a = b;
        b = t;
    }
}
