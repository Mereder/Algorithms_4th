package com.mereder.Algs_Exercise.Exercises1_1;

import java.util.Scanner;

/**
 * 编写一段代码，将一个正整数用二进制表示转换为一个String类型的值s
 */
public class E_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = N;
        String s = "";
        while (N > 0){
            int a = N % 2;
            s += a;
            N /= 2;
        }
        System.out.println(s);

        System.out.println(toBianryString(M));
    }

    /**
     * @param N
     * @return BinaryString
     * Official method from Algs4 book
     */
    public static String toBianryString(int N){
        String s = "";
        for (int n = N; n > 0 ; n /= 2) {
            s = (n % 2) +s;
        }
        return s;
    }
}
