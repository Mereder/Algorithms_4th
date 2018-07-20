package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 找出下列递归函数的问题
 *
 * solution:
 * 不满足递归调用条件：
 * 必定要有一个明确的结束递归的条件。（本题看似有 n <= 0 但是该条件对递归过程无约束）
 * 所以本题函数会循环往复直到发生StackOverFlow
 */
public class E_17 {
    public static String exR2(int n ){
        String s = exR2(n-3) + n + exR2(n-2) + n;
        if (n <= 0) return "";
        return  s;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(exR2(6));
    }
}
