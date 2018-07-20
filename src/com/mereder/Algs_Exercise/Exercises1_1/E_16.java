package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 给出exR1(6) 的 返回值
 *
 * Result:311361142246
 */
public class E_16 {
    public static String exR1(int n){
        if (n <= 0) return "";
        return exR1(n-3)+ n + exR1(n-2) + n;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(exR1(n));
    }
}
