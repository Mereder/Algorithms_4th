package com.mereder.Algs_Exercise.Exercises1_2;

/**
 * 以下代码会打印出什么：
 *
 * Result:
 * Hello World
 * 方法 s.toUpperCase()和方法s.substring(6,11);都是需要返回一个 String的
 */
public class E_05 {
    public static void main(String[] args) {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6,11);
        System.out.println(s);
    }
}
