package com.mereder.Algs_Exercise.Exercises1_1;

import java.util.Scanner;

/**
 * 编写一个静态方法lg() ，接受一个整型参数N，返回不大于  以2为底N的对数  的最大整数。
 * 不使用Math库
 *
 *
 * 整型参数N 确保了  以2为底N的对数 是大于等于0 的
 * 确保 2^x 小于等于 N;
 */
public class E_14 {
    public static int lg(int N){
        int sum = 1;
        int i = 0;
        while(sum <= N){
            sum *= 2;
            i++;
        }
        i = i-1;
        return i;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int result = lg(N);

        System.out.println(result);

    }
}
