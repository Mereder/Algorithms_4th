package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 以下代码段会打印出什么结果
 */
public class E_12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        /**
         * 应该是输出 a[i]  打印i没啥意义啊
         */
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
}
