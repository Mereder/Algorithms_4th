package com.mereder.Algs_Exercise.Exercises1_1;

/**
 * 将三个数字排序
 * 假设 a、b、c和t 都是同一种原始数字类型的变量。
 * 证明以下代码能够将a，b，c按照升序排列
 */

public class E_26 {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        int c = 3;
        int t ;
        if(a > b ){
            t = a; a = b; b = t;
        }
        if (a > c){
            t = a; a = c; c = t;
        }
        if (b > c){
            t = b; b = c; c = t;
        }
        System.out.println(a +" "+b+" "+c);
    }
}
