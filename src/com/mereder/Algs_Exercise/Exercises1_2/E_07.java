package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 一下递归函数的返回值是什么：
 * Result：
 * 将字符串倒置(分治思想)
 */
public class E_07 {
    public static String mystery(String s){
        int N = s.length();
        if (N <= 1 ) return s;
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);
        return mystery(b)+mystery(a);
    }
    public static void main(String[] args) {
        String string = "Hello World!Hello Java!";
        String invertString = mystery(string);
        System.out.println(invertString);
    }
}
